package org.mpei.C37_118_2011_ALL_FRAME.dataPacketConfiguration;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class dataPhasor {
    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Амплитуда--------------------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String amplitude;

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Угол-------------------------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private float factor;

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Метод для представления информации в человекочитаемом виде-------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    @Override
    public String toString() {
        return "amplitude: " + amplitude + ", angle=" + factor;
    }
}
