package pneumatter.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;

import java.io.IOException;

public class TestPacket extends AbstractPacket<TestPacket> {

    /**
     * This empty constructor with no parameters is required for the packet to work, I don't know why
     */
    public TestPacket() { }

    @Override
    public void readBytes(PacketBuffer buffer) throws IOException {

    }

    @Override
    public void writeBytes(PacketBuffer buffer) throws IOException {

    }

    @Override
    public void processMessage(EntityPlayer player, Side side) {
        System.out.println("We're netWORKING");
    }
}
