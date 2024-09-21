package org.example;

import lombok.extern.slf4j.Slf4j;
import org.pcap4j.core.PcapPacket;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Slf4j
public class Parser_IEEE_C37_118_2011 {
    public Optional<Frame_IEEE_C37_118_2011> parserData(PcapPacket pcapPacket) {
        try {
            byte[] data = pcapPacket.getRawData(); //Принятие массива байт
            Frame_IEEE_C37_118_2011 result = new Frame_IEEE_C37_118_2011();

            result.setMacDestination(byteArrayToMacAddress(data, 0));
            result.setMacSource(byteArrayToMacAddress(data, 6));
            result.setType(byteArrayToShort(data, 12));

            result.setVersion(byteToIntVersion(data, 14));
            result.setHeaderLength(byteToIntHeader(data, 14));
            result.setDifferentiatedServicesField(byteToDiff(data, 15));
            result.setLength(byteArrayToLength(data, 16));
            result.setIdentification(byteArrayToIdentification(data, 18));
            result.setFragmentOffset(byteArrayToFragmentOffset(data, 20));
            result.setTimeToLife(byteArrayToInt1(data, 22));
            result.setProtocol(byteArrayToInt1(data, 23));
            result.setHeaderCheckSum(byteArrayToHeaderCheckSum(data, 24));
            result.setIpDestination(byteArrayToIpAddress(data, 26));
            result.setIpSource(byteArrayToIpAddress(data, 30));

            result.setPortDestination(byteArrayToShort(data, 34));
            result.setPortSource(byteArrayToShort(data, 36));
            result.setSeqNum(byteArrayToInt4(data, 38));
            result.setAckNum(byteArrayToInt4(data, 42));
            result.setHeaderLengthTCP(byteToIntVersion(data, 46));
            result.setFlags(byteArrayToFlags(data, 46));
            result.setWindow(byteArrayToShort(data, 48));
            result.setCheckSum(byteArrayToCheck(data, 50));
            result.setUrgentPointer(byteArrayToShort(data, 52));


            result.getDataFrameIeeeC371182011().setSynchronizationWord(byteArrayToIdentification(data, 54));
            result.getDataFrameIeeeC371182011().setFrameSize(byteArrayToShort(data, 56));
            result.getDataFrameIeeeC371182011().setPmuDcIdNumber(byteArrayToShort(data, 58));
            result.getDataFrameIeeeC371182011().setSOC(byteToSOC(data, 60));
            result.getDataFrameIeeeC371182011().setTimeQualityFlag(byteArrayToInt1(data, 64));
            result.getDataFrameIeeeC371182011().setFractionOfSecond(byteArrayToInt3(data, 65));


            result.getDataFrameIeeeC371182011().getPmuIEEE_C37_118_2011().get(0).setFlag(byteArrayToFlags(data, 68));

            result.getDataFrameIeeeC371182011().getPmuIEEE_C37_118_2011().get(0).setVoltageA(byteToFloutAmpl(data, 70));
            result.getDataFrameIeeeC371182011().getPmuIEEE_C37_118_2011().get(0).setPhsA(byteToFloutAngle(data, 74));
            result.getDataFrameIeeeC371182011().getPmuIEEE_C37_118_2011().get(0).setVoltageB(byteToFloutAmpl(data, 78));
            result.getDataFrameIeeeC371182011().getPmuIEEE_C37_118_2011().get(0).setPhsB(byteToFloutAngle(data, 82));
            result.getDataFrameIeeeC371182011().getPmuIEEE_C37_118_2011().get(0).setVoltageC(byteToFloutAmpl(data, 86));
            result.getDataFrameIeeeC371182011().getPmuIEEE_C37_118_2011().get(0).setPhsC(byteToFloutAngle(data, 90));

            result.getDataFrameIeeeC371182011().getPmuIEEE_C37_118_2011().get(0).setFrequencyDeviation(byteArrayToShort(data, 94));
            result.getDataFrameIeeeC371182011().getPmuIEEE_C37_118_2011().get(0).setRate(byteArrayToShort(data, 96));
            result.getDataFrameIeeeC371182011().getPmuIEEE_C37_118_2011().get(0).setDigital(byteArrayToIdentification(data, 98));




            return Optional.of(result);
        } catch (Exception exception) {
            log.error("Cannot parse C37.118-2011 packet");
        }
        return Optional.empty();
    }

    public static String byteArrayToMacAddress(byte[] data, int offset) {
        return String.format("%02X:%02X:%02X:%02X:%02X:%02X", //Возврат String в нужном формате.
                data[offset],
                data[1 + offset],
                data[2 + offset],
                data[3 + offset],
                data[4 + offset],
                data[5 + offset]
        );
    }

    public static short byteArrayToShort(byte[] data, int offset) {
        return (short) (data[offset + 1] & 0xFF | (data[offset] & 0xFF) << 8);
    }

    public static int byteArrayToInt1(byte[] data, int offset) {
        return data[offset] & 0xFF;
    }

    public static int byteArrayToInt3(byte[] data, int offset) {
        return data[offset + 2] & 0xFF | (data[offset + 1] & 0xFF) << 8 | (data[offset] & 0xFF) << 16;
    }

    public static int byteArrayToInt4(byte[] data, int offset) {
        return data[offset + 3] & 0xFF | (data[offset + 2] & 0xFF) << 8 | (data[offset + 1] & 0xFF) << 16 | (data[offset] & 0xFF) << 24;
    }

    public static int byteToIntVersion(byte[] data, int offset) {
        return (data[offset] >> 4 & 0xFF);
    }

    public static int byteToIntHeader(byte[] data, int offset) {
        return ((data[offset] & 0b00001111) & 0xFF);
    }

    public static String byteToDiff(byte[] data, int offset) {
        return String.format("0x%02x", data[offset]);
    }

    public static int byteArrayToLength(byte[] data, int offset) {
        return (data[offset + 1] & 0xFF | (data[offset] & 0xFF) << 8);
    }

    public static String byteArrayToIdentification(byte[] data, int offset) {
        return String.valueOf(((data[offset] & 0xFF) << 8) | (data[1 + offset] & 0xFF));
    }

    public static String byteArrayToFragmentOffset(byte[] data, int offset) {
        return String.valueOf(((data[offset] & 0xFF) << 8) | (data[1 + offset] & 0xFF));
    }

    public static String byteArrayToHeaderCheckSum(byte[] data, int offset) {
        return String.valueOf(((data[offset] & 0xFF) << 8) | (data[1 + offset] & 0xFF));
    }

    public static String byteArrayToIpAddress(byte[] data, int offset) {
        return String.format("%d.%d.%d.%d.", //Возврат String в нужном формате.
                data[offset] & 0xFF,
                data[1 + offset] & 0xFF,
                data[2 + offset] & 0xFF,
                data[3 + offset] & 0xFF
        );
    }

    public static String byteArrayToFlags(byte[] data, int offset) {
        return String.valueOf(((data[offset] & 0xFF) << 8) | (data[1 + offset] & 0xFF));
    }

    public static String byteArrayToCheck(byte[] data, int offset) {
        return String.valueOf(((data[offset] & 0xFF) << 8) | (data[1 + offset] & 0xFF));
    }


    public static float byteToFloutAmpl(byte[] data, int offset) {
        return Float.intBitsToFloat(byteArrayToInt4(data, offset));
    }

    public static float byteToFloutAngle(byte[] data, int offset) {
        return (float) (Float.intBitsToFloat(byteArrayToInt4(data, offset)) * 180 / Math.PI);
    }

    public static Date byteToSOC(byte[] data, int offset) {
        return Date.from(Instant.ofEpochSecond(byteArrayToInt4(data, offset)));
    }

}
