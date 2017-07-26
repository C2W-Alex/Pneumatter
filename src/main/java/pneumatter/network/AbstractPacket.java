package pneumatter.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import java.io.IOException;

/**
 * Combines IMessage and IMessageHandler into one class
 */
public abstract class AbstractPacket<T extends AbstractPacket> implements IMessage, IMessageHandler<T, IMessage> {
    /**
     * Just some wrappers for the fromBytes, toBytes, onMessage
     */
    public abstract void readBytes(PacketBuffer buffer) throws IOException;

    public abstract void writeBytes(PacketBuffer buffer) throws IOException;

    public abstract void processMessage(EntityPlayer player, Side side);


    @Override
    public void fromBytes(ByteBuf buf) {
        try {
            readBytes(new PacketBuffer(buf));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        try {
            writeBytes(new PacketBuffer(buf));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IMessage onMessage(T message, MessageContext ctx) {
        message.processMessage(ctx.getServerHandler().player, ctx.side);
        return null;
    }
}
