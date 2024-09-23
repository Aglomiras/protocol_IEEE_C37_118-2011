package org.mpei.C37_118_2011_1PMU;

import org.mpei.C37_118_2011_1PMU.dataPacket.DtoPacketBleach;
import org.mpei.C37_118_2011_1PMU.packetCatcher.FrameListnerBleach;
import org.mpei.C37_118_2011_1PMU.parserPacket.ParserFrameBleach;
import org.mpei.C37_118_2011_ALL_FRAME.frame.grandFrame.Frame_Ethernet_TCP_IP_IEEE_C37_118_2011;

import java.util.Optional;

public class StarterBleach {
    public static void main(String[] args) {
        FrameListnerBleach listner = new FrameListnerBleach();
        listner.setNicName("VirtualBox Host-Only Ethernet Adapter");

        ParserFrameBleach parserC37 = new ParserFrameBleach();
        DtoPacketBleach dtoC37 = new DtoPacketBleach();

        listner.addListener(pcapPacket -> {
            Optional<Frame_Ethernet_TCP_IP_IEEE_C37_118_2011> frameC37 = parserC37.parserData(pcapPacket, dtoC37);

            if (frameC37.isPresent()) {
                System.out.println(frameC37.get());
                System.out.println();
            }
//            System.out.println(pcapPacket);
        });
        listner.start();
    }
}
