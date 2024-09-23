package org.mpei.C37_118_2011_ALL_FRAME.dataPacketData;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**---------------------------------------------------------------------------------------------------------------------
 * Класс для аналоговых значений. Содержит одно поле значения с плавающей точкой----------------------------------------
 * -------------------------------------------------------------------------------------------------------------------*/
public class dataAnalogChanel {
    private float value;                                                                               //Размер: 4 байта

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
