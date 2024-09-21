package org.example;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PMU_IEEE_C37_118_2011 {
    private String flag;

    private float voltageA;
    private float phsA;
    private float voltageB;
    private float phsB;
    private float voltageC;
    private float phsC;

    private short frequencyDeviation;
    private short rate;
    private short analog;
    private String digital;

    public PMU_IEEE_C37_118_2011() {
        this.digital = "0";
    }

    @Override
    public String toString() {
        return "PMU_IEEE_C37_118_2011 { " + '\n' +
                "\t\t\tFlag: " + flag + '\n' +
                "\t\t\tVoltage A: " + voltageA + " V" + '\n' +
                "\t\t\tPhs A: " + phsA + " ang." + '\n' +
                "\t\t\tVoltage B: " + voltageB + " V" + '\n' +
                "\t\t\tPhs B: " + phsB + " ang." + '\n' +
                "\t\t\tVoltage C: " + voltageC + " V" + '\n' +
                "\t\t\tPhs C: " + phsC + " ang." + '\n' +
                "\t\t\tFrequency Deviation: " + frequencyDeviation + " Hz" + '\n' +
                "\t\t\tRate: " + rate + " Hz/s" + '\n' +
                "\t\t\tAnalog: " + analog + '\n' +
                "\t\t\tDigital: 0x" + Integer.toHexString(Integer.parseInt(digital)) + '\n' +
                "\t\t" + '}' + '\n';
    }
}
