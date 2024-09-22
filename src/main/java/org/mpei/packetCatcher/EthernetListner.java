package org.mpei.packetCatcher;

import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.pcap4j.core.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;


@Slf4j
public class EthernetListner {
    //Создадим метод, который будет находить все сетевые карты на компьютере
    /***/
    static {
        try {
            for (PcapNetworkInterface nic : Pcaps.findAllDevs()) log.info("Found NIC: {}", nic);
        } catch (PcapNativeException e) {
            throw new RuntimeException(e);
        }
    }

    /***/
    @Setter
    private String nicName;
    private PcapHandle handle; //Обработчик, который вешается на сетевую карту и позволяет перехватывать пакеты.
    private final List<PacketListener> listeners = new CopyOnWriteArrayList<>(); //Делаем через copy, чтоб избежать ошибок при многопточной работе.

    private final PacketListener defaultPacketListener = pcapPacket -> { //Метод для принятия сырых пакетов, обернутый в лямбда функцию.
        listeners.forEach(listeners -> listeners.gotPacket(pcapPacket));
//        System.out.println(pcapPacket);
    };

    /***/
    @SneakyThrows
    public void start() {
        if (handle == null) {
            initializeNetworkInterface();

            if (handle != null) {

                String filter = "ether proto 0x0800 && ether dst 00:1d:60:63:85:40 && len >= 1500"; //
                handle.setFilter(filter, BpfProgram.BpfCompileMode.OPTIMIZE);

                Thread captureThread = new Thread(() -> { //Создание функционального интерфейса (функциональный интерфейс - интерфейс, у которого есть один метод). Такие интерфейсы можно записать в лямбда выражении.
                    try {
                        log.info("Starting packet capture");
                        handle.loop(0, defaultPacketListener); //Принятие сырых пакетов
                    } catch (PcapNativeException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (NotOpenException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("Finish packet capture");

                });
                captureThread.start();
            }
        }
    }

    /***/
    //Создадим метод для поиска определенной сетевой карты
    @SneakyThrows //Аннотация, которая делает рантайм эксепшены
    private void initializeNetworkInterface() {

        Optional<PcapNetworkInterface> nic = Pcaps.findAllDevs().stream()
                .filter(i -> nicName.equals(i.getDescription()))
                .findFirst();
        if (nic.isPresent()) { //Если сетевай карта найдена, то создадим область для ее работы
            handle = nic.get().openLive(65535, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, 100); //Создаем максимальное число памяти для пакета. Вторая переменная позволяет пропускать пакеты в операционную память, которые ей не предназначаются.
            log.info("Network handler created: {}", nic);
        } else { //Если такой сетевой карты нет, то выбрасываем ошибку.
            log.error("Network Interface is not found");
        }
    }

    /***/
    public void addListener(PacketListener listener) {
        listeners.add(listener);
    }


}
