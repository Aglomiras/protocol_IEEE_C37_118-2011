package org.mpei.C37_118_2011_ALL_FRAME.frame.lowFrame;

import lombok.Getter;
import lombok.Setter;
import org.mpei.C37_118_2011_ALL_FRAME.dataPacketConfiguration.dataConfiguration;

import java.util.ArrayList;

@Setter
@Getter
public class Frame_Configuration_IEEE_C37_118_2011 {
    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Служебный байт (не известно для чего)----------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String config;                                                                              //Размер: 1 байт

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Разрешение временной метки---------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String resolution;                                                                          //Размер: 3 байт

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Количество PMU---------------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private int numberPMU;                                                                              //Размер: 2 байт

    /**
     * Массив структур для Config пакетов protocol IEEE C37.118-2011
     */
    private ArrayList<dataConfiguration> dataPmu = new ArrayList() {
    };

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Метод по заполнению массива dataPmu, нужным количеством шаблонов структур----------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    public void completionDataConfiguration() {
        for (int i = 0; i < this.numberPMU; i++) {
            this.dataPmu.add(new dataConfiguration());
        }
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Вспомогательный метод для представления информации в человекочитаемом виде---------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    @Override
    public String toString() {
        return "\t\tFrame Configuration [IEEE C37.118-2011] {\n" +
                "\t\t\tConfig: " + this.config + '\n' +
                "\t\t\tResolution: " + this.resolution + '\n' +
                "\t\t\tNumber PMU: " + this.numberPMU + '\n' +
                "\t\t\tConfiguration PMU: \n" + toStringDataConfiguration() + '\n' +
                "\t\t}";
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Метод для корректного отображения вложенной структуры------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    public String toStringDataConfiguration() {
        StringBuilder dataConf = new StringBuilder();
        for (int i = 0; i < this.numberPMU; i++) {
            dataConf.append("\t\t\t").append(i + 1)
                    .append(" ")
                    .append(dataPmu.get(i).toString());
        }
        return dataConf.toString();
    }

}
