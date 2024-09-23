package org.mpei.C37_118_2011_4PMU.dataPacket;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Frame_IEEE_C37_118_2011 {
    /**
     * Ethernet II
     */
    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Mac destination - адрес получателя-------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String macDestination;                                                                     //Размер: 6 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Mac source - адрес источника-------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String macSource;                                                                          //Размер: 6 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Type - тип сообщения (C37.118)-----------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private short type;                                                                                //Размер: 2 байта

    /**
     * Internet Protocol
     */
    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Version----------------------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private int version;                                                                             //Размер: 0,5 байта
    /**
     * Header length
     */
    private int headerLength;                                                                        //Размер: 0,5 байта
    /**
     * Differentiated services field
     */
    private String differentiatedServicesField;                                                        //Размер: 1 байта
    /**
     * Length
     */
    private int length;                                                                                //Размер: 2 байта
    /**
     * Identification
     */
    private String identification;                                                                     //Размер: 2 байта
    /**
     * Fragment offset
     */
    private String fragmentOffset;                                                                     //Размер: 2 байта
    /**
     * Time to life
     */
    private int timeToLife;                                                                            //Размер: 1 байта
    /**
     * Protocol
     */
    private int protocol;                                                                              //Размер: 1 байта
    /**
     * Header checksum
     */
    private String headerCheckSum;                                                                     //Размер: 2 байта
    /**
     * IP destination
     */
    private String ipDestination;                                                                      //Размер: 4 байта
    /**
     * IP source
     */
    private String ipSource;                                                                           //Размер: 4 байта

    /**
     * Transmission Control Protocol
     */
    /**
     * Port destination
     */
    private int portDestination;                                                                       //Размер: 2 байта
    /**
     * Port source
     */
    private int portSource;                                                                            //Размер: 2 байта
    /**
     * Sequence Number
     */
    private int seqNum;                                                                                //Размер: 4 байта
    /**
     * Acknowledgment
     */
    private int ackNum;                                                                                //Размер: 4 байта
    /**
     * Header length TCP
     */
    private int headerLengthTCP;                                                                       //Размер: 1 байта
    /**
     * Flags
     */
    private String flags;                                                                              //Размер: 2 байта
    /**
     * Window
     */
    private short window;                                                                              //Размер: 2 байта
    /**
     * Checksum
     */
    private String checkSum;                                                                           //Размер: 2 байта
    /**
     * Urgent Pointer
     */
    private short urgentPointer;                                                                       //Размер: 2 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Сами данные по протоколу IEEE C37.118-2011-----------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private DataFrame_IEEE_C37_118_2011 dataFrameIeeeC371182011;                                      //Размер: 456 байт

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Конструктор:-----------------------------------------------------------------------------------------------------
     * - Заполняет строковые поля начальными данными, чтобы не было ошибки в начале работы программы;-------------------
     * - Создает структуру с данными по протоколу C37.118-2011;---------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    public Frame_IEEE_C37_118_2011(int phasor, int analog) {
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
        this.dataFrameIeeeC371182011 = new DataFrame_IEEE_C37_118_2011(phasor, analog);
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Метод для представления информации в человекочитаемом виде-------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
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
