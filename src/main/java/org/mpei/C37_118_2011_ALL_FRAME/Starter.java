package org.mpei.C37_118_2011_ALL_FRAME;


import org.mpei.C37_118_2011_ALL_FRAME.frame.grandFrame.Frame_Ethernet_TCP_IP_IEEE_C37_118_2011;
import org.mpei.C37_118_2011_ALL_FRAME.parserFrame.Parser_All_Frame_IEEE_C37_118_2011;

import java.util.Optional;

public class Starter {
    public static void main(String[] args) {
        FrameListner listner = new FrameListner();
        listner.setNicName("VirtualBox Host-Only Ethernet Adapter");

        Parser_All_Frame_IEEE_C37_118_2011 parserC37 = new Parser_All_Frame_IEEE_C37_118_2011();

        listner.addListener(pcapPacket -> {
            Optional<Frame_Ethernet_TCP_IP_IEEE_C37_118_2011> frameC37 = parserC37.parserData(pcapPacket);

            if (frameC37.isPresent()) {
                System.out.println(frameC37.get());
                System.out.println();
            }
//            System.out.println(pcapPacket);
        });
        listner.start();
    }
}
