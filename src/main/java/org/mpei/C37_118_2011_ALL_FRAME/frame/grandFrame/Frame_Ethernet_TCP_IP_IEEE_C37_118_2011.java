package org.mpei.C37_118_2011_ALL_FRAME.frame.grandFrame;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Frame_Ethernet_TCP_IP_IEEE_C37_118_2011 {
    /**-----------------------------------------------------------------------------------------------------------------
     * Ethernet II------------------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
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

    /**-----------------------------------------------------------------------------------------------------------------
     * Internet Protocol------------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Version - версия IP----------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private int version;                                                                             //Размер: 0,5 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Header length - длина заголовка----------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private int headerLength;                                                                        //Размер: 0,5 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Differentiated services field - тип обслуживания-----------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String differentiatedServicesField;                                                        //Размер: 1 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Length - общая длина пакета--------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private int length;                                                                                //Размер: 2 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Identification - идентификатор для фрагмента пакета--------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String identification;                                                                     //Размер: 2 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Fragment offset - указатель смещения пакетов---------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String fragmentOffset;                                                                     //Размер: 2 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Time to life - счетчик жизни пакета------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private int timeToLife;                                                                            //Размер: 1 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Protocol - указатель протокола на транспортном уровне------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private int protocol;                                                                              //Размер: 1 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Header checksum - контрольная сумма заголовка--------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String headerCheckSum;                                                                     //Размер: 2 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * IP destination - IP-адрес получателя-----------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String ipDestination;                                                                      //Размер: 4 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * IP source - IP-адрес источника-----------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String ipSource;                                                                           //Размер: 4 байта

    /**-----------------------------------------------------------------------------------------------------------------
     * Transmission Control Protocol------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Port destination - порт получателя-------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private int portDestination;                                                                       //Размер: 2 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Port source - порт источника-------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private int portSource;                                                                            //Размер: 2 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Sequence Number - порядковый номер первого байта-----------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private int seqNum;                                                                                //Размер: 4 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Acknowledgment - порядковый номер следующего байта---------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private int ackNum;                                                                                //Размер: 4 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Header length TCP - длина заголовка TCP--------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private int headerLengthTCP;                                                                       //Размер: 1 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Flags - флаг-----------------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String flags;                                                                              //Размер: 2 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Window - размер окна---------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private short window;                                                                              //Размер: 2 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Checksum - контрольная сумма-------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private String checkSum;                                                                           //Размер: 2 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Urgent Pointer - указатель смещения начиная с порядкового номера-------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private short urgentPointer;                                                                       //Размер: 2 байта

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Сами данные по протоколу IEEE C37.118-2011-----------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    private General_Frame_IEEE_C37_118_2011 general_frame_ieee_c37_118_2011;

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Конструктор:-----------------------------------------------------------------------------------------------------
     * - Создает структуру с данными по протоколу C37.118-2011;---------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    public Frame_Ethernet_TCP_IP_IEEE_C37_118_2011() {
        this.general_frame_ieee_c37_118_2011 = new General_Frame_IEEE_C37_118_2011();
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * Метод для представления информации в человекочитаемом виде-------------------------------------------------------
     * -----------------------------------------------------------------------------------------------------------------
     */
    @Override
    public String toString() {
        return "Frame [IEEE C37.118-2011] {" + '\n' +
                "\tMac destination: " + macDestination + '\n' +
                "\tMac source:" + macSource + '\n' +
                "\tType: " + type + '\n' + '\n' +

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
                "\tIP source: " + ipSource + '\n' + '\n' +

                "\tPort source: " + portSource + '\n' +
                "\tPort destination: " + portDestination + '\n' +
                "\tSequence Number: " + seqNum + '\n' +
                "\tAcknowledgment: " + ackNum + '\n' +
                "\tHeader length TCP: " + (headerLengthTCP * 4) + " byte (" + headerLengthTCP + ")" + '\n' +
                "\tFlags: 0x" + Integer.toHexString(Integer.parseInt(flags)) + '\n' +
                "\tWindow: " + window + '\n' +
                "\tChecksum: 0x" + Integer.toHexString(Integer.parseInt(checkSum)) + '\n' +
                "\tUrgent Pointer: " + urgentPointer + '\n' +
                "\t" + general_frame_ieee_c37_118_2011.toString() + '\n' +
                '}' + '\n';
    }
}
