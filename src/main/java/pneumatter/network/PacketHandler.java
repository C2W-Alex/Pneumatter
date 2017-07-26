package pneumatter.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import pneumatter.Pneumatter;

public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Pneumatter.MODID);

    public static void registerPackets() {
        registerMessage(TestPacket.class, Side.SERVER);
    }

    private static int ID = 0;

    /**
     * Use this to register the packets
     * @param packet The packet to register
     * @param side The side that the packet is received, not sent from
     */
    private static <T extends AbstractPacket<T>> void registerMessage(Class<T> packet, Side side) {
        INSTANCE.registerMessage(packet, packet, ID++, side);
    }

}
