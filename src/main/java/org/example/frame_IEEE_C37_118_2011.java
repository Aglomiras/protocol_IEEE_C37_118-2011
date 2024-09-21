package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class frame_IEEE_C37_118_2011 {

    private String macDestination;
    private String macSource;
    private short type;

    private int version;
    private int headerLength;
    private String differentiatedServicesField;
    private int length;
    private String identification;
    private String fragmentOffset;
    private int timeToLife;
    private int protocol;
    private String headerCheckSum;
    private String ipDestination;
    private String ipSource;

    private int portDestination;
    private int portSource;
    private int seqNum;
    private int ackNum;
    private int headerLengthTCP;
    private String flags;
    private short window;
    private String checkSum;
    private short urgentPointer;

    @Setter
    @Getter
    public class DataFrame_IEEE_C37_118_2011 {
        private short synchronizationWord;
        private short frameSize;
        private short pmuDcIdNumber;
        private Date SOC;
        private String qualityFlag;
        private int fractionOfSecond;

    }

}
