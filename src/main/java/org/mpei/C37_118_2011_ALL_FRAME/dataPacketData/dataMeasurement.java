package org.mpei.C37_118_2011_ALL_FRAME.dataPacketData;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**---------------------------------------------------------------------------------------------------------------------
 * Класс для измеренных значений. Содержит поля для хранения амплитуды и фазового угла----------------------------------
 * -------------------------------------------------------------------------------------------------------------------*/
public class dataMeasurement {
    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Амплитуда--------------------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private float amplitude;                                                                           //Размер: 4 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Угол (фаза)------------------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private float angle;                                                                               //Размер: 4 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Конструктор:-----------------------------------------------------------------------------------------------------
     * - Задание начальных значений, чтобы не было ошибки---------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    public dataMeasurement() {
        this.amplitude = 0.0F;
        this.angle = 0.0F;
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Метод для представления информации в человекочитаемом виде-------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    @Override
    public String toString() {
        return "amplitude: " + amplitude + " angle: " + angle;
    }

    public String toStringComplex() {
        float vectorMnim = (float) (this.angle * Math.PI / 180.0);
        float vectorAmple = (float) Math.sqrt(this.amplitude * this.amplitude + Math.abs(vectorMnim * vectorMnim));
        float vectorAngle = (float) Math.atan(vectorMnim/this.amplitude);

        return "amplitude: " + vectorAmple + " V, angle: " + vectorAngle * 180.0 / Math.PI + " degr;";
    }
}
