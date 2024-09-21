package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
public class DataFrame_IEEE_C37_118_2011 {
    private String synchronizationWord;
    private short frameSize;
    private short pmuDcIdNumber;
    private Date SOC;
    private int timeQualityFlag;
    private int fractionOfSecond;

    private ArrayList<PMU_IEEE_C37_118_2011> pmuIEEE_C37_118_2011 = new ArrayList<PMU_IEEE_C37_118_2011>() {
    };

    public DataFrame_IEEE_C37_118_2011() {
        this.synchronizationWord = "0";
        for (int i = 0; i < 4; i++) {
            pmuIEEE_C37_118_2011.add(new PMU_IEEE_C37_118_2011());
        }
    }

    @Override
    public String toString() {
        return "\tDataFrame_IEEE_C37_118_2011 {" + '\n' +
                "\t\tSynchronization word: " + Integer.toHexString(Integer.parseInt(synchronizationWord)) + '\n' +
                "\t\tFramesize: " + frameSize + '\n' +
                "\t\tPMU/DC ID number: " + pmuDcIdNumber + '\n' +
                "\t\tSOC time stamp: " + SOC + '\n' +
                "\t\tTime quality flag: " + timeQualityFlag + '\n' +
                "\t\tFraction of second: " + fractionOfSecond + '\n' +
                "\t\tPMU: " + '\n' +
                toStringPMUArray() +
                "\t" + '}';
    }

    public String toStringPMUArray() {
        StringBuilder stringPMU = new StringBuilder();

        for (int i = 0; i < pmuIEEE_C37_118_2011.size(); i++) {
            stringPMU.append("\t").append(i + 1).append(" ").append(pmuIEEE_C37_118_2011.get(i).toString());
        }
        return stringPMU.toString();
    }
}
