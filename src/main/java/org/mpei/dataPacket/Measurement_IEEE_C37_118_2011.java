package org.mpei.dataPacket;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Measurement_IEEE_C37_118_2011 {
    /***/
    private float amplitude;
    private float angle;

    /***/
    public Measurement_IEEE_C37_118_2011() {
        this.amplitude = 0.0F;
        this.angle = 0.0F;
    }

    /***/
    @Override
    public String toString() {
        return "amplitude: " + amplitude + " angle: " + angle;
    }
}
