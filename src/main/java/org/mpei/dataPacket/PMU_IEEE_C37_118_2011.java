package org.mpei.dataPacket;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class PMU_IEEE_C37_118_2011 {
    /***/
    private String flag;
    /***/
    private ArrayList<Measurement_IEEE_C37_118_2011> measurements = new ArrayList<Measurement_IEEE_C37_118_2011>() {
    };

    /***/
    private short frequencyDeviation;
    private short rate;
    private short analog;
    private ArrayList<AnalogValues_IEEE_C37_118_2011> analogs = new ArrayList<AnalogValues_IEEE_C37_118_2011>() {
    };
    private String digital;

    /***/
    public PMU_IEEE_C37_118_2011(int phasor, int analog) {
        this.digital = "0";
        for (int i = 0; i < phasor; i++) {
            this.measurements.add(new Measurement_IEEE_C37_118_2011());
        }
        for (int i = 0; i < analog; i++) {
            this.analogs.add(new AnalogValues_IEEE_C37_118_2011());
        }
    }

    /***/
    @Override
    public String toString() {
        return "PMU_IEEE_C37_118_2011 { " + '\n' +
                "\t\t\tFlag: " + flag + '\n' +
                toStringMeasurement() +
                "\t\t\tFrequency Deviation: " + frequencyDeviation + " Hz" + '\n' +
                "\t\t\tRate: " + rate + " Hz/s" + '\n' +
                "\t\t\tAnalog: " + analog + '\n' +
                "\t\t\tDigital: 0x" + Integer.toHexString(Integer.parseInt(digital)) + '\n' +
                "\t\t" + '}' + '\n';
    }

    /***/
    public String toStringMeasurement() {
        StringBuilder measurements = new StringBuilder();
        for (int i = 0; i < this.measurements.size(); i++) {
            measurements.append("\t\t\t").append(i + 1).append(" phasor: ").append(this.measurements.get(i).toString()).append('\n');
        }
        return measurements.toString();
    }
}
