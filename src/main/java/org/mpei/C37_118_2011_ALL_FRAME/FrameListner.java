package org.mpei.C37_118_2011_ALL_FRAME;

import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.pcap4j.core.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class FrameListner {
    /**-----------------------------------------------------------------------------------------------------------------
     * Метод, который находит все сетевые карты на компьютере-----------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     * */
    static {
        try {
            for (PcapNetworkInterface nic : Pcaps.findAllDevs()) log.info("Found NIC: {}", nic);
        } catch (PcapNativeException e) {
            throw new RuntimeException(e);
        }
    }

    @Setter
    private String nicName;

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Обработчик, который вешается на сетевую карту и позволяет перехватывать пакеты-----------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private PcapHandle handle;

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Делаем через copy, чтоб избежать ошибок при многопточной работе--------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private final List<PacketListener> listeners = new CopyOnWriteArrayList<>();

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Метод для принятия сырых пакетов, обернутый в лямбда функцию-----------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private final PacketListener defaultPacketListener = pcapPacket -> { //
        listeners.forEach(listeners -> listeners.gotPacket(pcapPacket));
    };

    /***/
    @SneakyThrows
    public void start() {
        if (handle == null) {
            initializeNetworkInterface();

            if (handle != null) {
                /**-----------------------------------------------------------------------------------------------------
                 * Выхватываем пакеты только протокола C37.118----------------------------------------------------------
                 * -----------------------------------------------------------------------------------------------------
                 * */
                String filter = "ether proto 0x0800 && (len == 1514 || len == 510 || len == 72)";
                handle.setFilter(filter, BpfProgram.BpfCompileMode.OPTIMIZE);

                Thread captureThread = new Thread(() -> {
                    try {
                        log.info("Starting packet capture");
                        /**---------------------------------------------------------------------------------------------
                         * Принятие сырых пакетов-----------------------------------------------------------------------
                         * ---------------------------------------------------------------------------------------------
                         * */
                        handle.loop(0, defaultPacketListener);
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

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Метод для поиска определенной сетевой карты----------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    @SneakyThrows
    private void initializeNetworkInterface() {
        Optional<PcapNetworkInterface> nic = Pcaps.findAllDevs()
                .stream().filter(i -> nicName.equals(i.getDescription())).findFirst();
        /**-------------------------------------------------------------------------------------------------------------
         * Если сетевай карта найдена, то создадим область для ее работы------------------------------------------------
         * -------------------------------------------------------------------------------------------------------------
         * */
        if (nic.isPresent()) {
            /**Создаем максимальное число памяти для пакета. Вторая переменная позволяет пропускать пакеты в------------
             * операционную память, которые ей не предназначаются.------------------------------------------------------
             * */
            handle = nic.get().openLive(65507, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, 100);
            log.info("Network handler created: {}", nic);
        } else {
            /**---------------------------------------------------------------------------------------------------------
             * Если такой сетевой карты нет, то выбрасываем ошибку.-----------------------------------------------------
             * ---------------------------------------------------------------------------------------------------------
             * */
            log.error("Network Interface is not found");
        }
    }

    /***/
    public void addListener(PacketListener listener) {
        listeners.add(listener);
    }
}
