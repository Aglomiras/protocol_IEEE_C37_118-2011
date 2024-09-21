package org.example;

import lombok.extern.slf4j.Slf4j;
import org.pcap4j.core.PcapPacket;

import java.util.Optional;

@Slf4j
public class parser_IEEE_C37_118_2011 {
    public Optional<frame_IEEE_C37_118_2011> parserData(PcapPacket pcapPacket) {
        try {
            byte[] data = pcapPacket.getRawData(); //Принятие массива байт
            frame_IEEE_C37_118_2011 result = new frame_IEEE_C37_118_2011();

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

}
