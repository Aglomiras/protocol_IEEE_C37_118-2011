package org.example;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Frame_IEEE_C37_118_2011 {
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

    private DataFrame_IEEE_C37_118_2011 dataFrameIeeeC371182011 = new DataFrame_IEEE_C37_118_2011();

    public Frame_IEEE_C37_118_2011() {
        this.macDestination = "0";
        this.macSource = "0";
        this.differentiatedServicesField = "0";
        this.identification = "0";
        this.fragmentOffset = "0";
        this.headerCheckSum = "0";
        this.ipDestination = "0";
        this.ipSource = "0";
        this.flags = "0";
        this.checkSum = "0";
    }

    @Override
    public String toString() {
        return "Frame_IEEE_C37_118_2011 {" + '\n' +
                "\tMac destination: " + macDestination + '\n' +
                "\tMac source:" + macSource + '\n' +
                "\tType: " + type + '\n' +

                "\tVersion: " + version + '\n' +
                "\tHeader length: " + headerLength + '\n' +
                "\tDifferentiated services field: " + differentiatedServicesField + '\n' +
                "\tLength: " + length + '\n' +
                "\tIdentification: 0x" + Integer.toHexString(Integer.parseInt(identification)) + '\n' +
                "\tFragment offset: 0x" + Integer.toHexString(Integer.parseInt(fragmentOffset)) + '\n' +
                "\tTime to life: " + timeToLife + '\n' +
                "\tProtocol: " + protocol + '\n' +
                "\tHeader checksum: 0x" + Integer.toHexString(Integer.parseInt(headerCheckSum)) + '\n' +
                "\tIP destination: " + ipDestination + '\n' +
                "\tIP source: " + ipSource + '\n' +

                "\tPort destination: " + portDestination + '\n' +
                "\tPort source: " + portSource + '\n' +
                "\tSequence Number: " + seqNum + '\n' +
                "\tAcknowledgment: " + ackNum + '\n' +
                "\tHeader length TCP: " + headerLengthTCP + '\n' +
                "\tFlags: 0x" + Integer.toHexString(Integer.parseInt(flags)) + '\n' +
                "\tWindow: " + window + '\n' +
                "\tChecksum: 0x" + Integer.toHexString(Integer.parseInt(checkSum)) + '\n' +
                "\tUrgent Pointer: " + urgentPointer + '\n' +
                dataFrameIeeeC371182011.toString() + '\n' +
                '}' + '\n';
    }
}
