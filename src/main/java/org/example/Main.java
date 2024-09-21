package org.example;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        EthernetListner listner = new EthernetListner();
        listner.setNicName("VirtualBox Host-Only Ethernet Adapter");

        Parser_IEEE_C37_118_2011 parserC37 = new Parser_IEEE_C37_118_2011();

        listner.addListener(pcapPacket -> {
            Optional<Frame_IEEE_C37_118_2011> frameC37 = parserC37.parserData(pcapPacket);

            if (frameC37.isPresent()) {
                System.out.println(frameC37.get().toString());

                System.out.println();
            }
//            System.out.println(pcapPacket);
        });
        listner.start();
    }
}