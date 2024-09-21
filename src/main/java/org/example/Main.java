package org.example;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EthernetListner listner = new EthernetListner();
        listner.setNicName("VirtualBox Host-Only Ethernet Adapter");

        parser_IEEE_C37_118_2011 parserC37 = new parser_IEEE_C37_118_2011();


        listner.addListener(pcapPacket -> {
            Optional<frame_IEEE_C37_118_2011> frameC37 = parserC37.parserData(pcapPacket);

            if (frameC37.isPresent()) {
                System.out.println("macDestination: " + frameC37.get().getMacDestination());
                System.out.println("macSource: " + frameC37.get().getMacSource());
                System.out.println("type: " + String.format("0x%04X", frameC37.get().getType()));

                System.out.println("version: " + frameC37.get().getVersion());
                System.out.println("headerLength: " + frameC37.get().getHeaderLength());
                System.out.println("differentiatedServicesField: " + frameC37.get().getDifferentiatedServicesField());
                System.out.println("length: " + frameC37.get().getLength());
                System.out.println("identification: 0x" + Integer.toHexString(Integer.parseInt(frameC37.get().getIdentification())));
                System.out.println("fragmentOffset: 0x" + Integer.toHexString(Integer.parseInt(frameC37.get().getFragmentOffset())));
                System.out.println("timeToLife: " + frameC37.get().getTimeToLife());
                System.out.println("protocol: TCP(" + frameC37.get().getProtocol() + ")");
                System.out.println("headerCheckSum: 0x" + Integer.toHexString(Integer.parseInt(frameC37.get().getHeaderCheckSum())));
                System.out.println("ipDestination: " + frameC37.get().getIpDestination());
                System.out.println("ipSource: " + frameC37.get().getIpSource());

                System.out.println("portDestination: " + frameC37.get().getPortDestination());
                System.out.println("portSource: " + frameC37.get().getPortSource());
                System.out.println("sequenceNumber: " + frameC37.get().getSeqNum());
                System.out.println("acknowledgmentNumber: " + frameC37.get().getAckNum());
                System.out.println("headerLengthTCP: " + frameC37.get().getHeaderLengthTCP());
                System.out.println("flags: 0x" + Integer.toHexString(Integer.parseInt(frameC37.get().getFlags())));
                System.out.println("window: " + frameC37.get().getWindow());
                System.out.println("checkSum: 0x" + Integer.toHexString(Integer.parseInt(frameC37.get().getCheckSum())));
                System.out.println("urgentPointer: " + frameC37.get().getUrgentPointer());
                System.out.println();

            }


            System.out.println(pcapPacket);
        });
        listner.start();
    }
}