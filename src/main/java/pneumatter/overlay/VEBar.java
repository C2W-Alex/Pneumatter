package pneumatter.overlay;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import pneumatter.Pneumatter;
import pneumatter.network.PacketHandler;
import pneumatter.network.TestPacket;

@Mod.EventBusSubscriber(modid = Pneumatter.MODID)
public class VEBar extends GuiScreen {

    @SubscribeEvent
    public static void renderOverlayEvent(RenderGameOverlayEvent.Text event) {
        PacketHandler.INSTANCE.sendToServer(new TestPacket());
        //TODO semi-transparent bar on the right side of the screen (vertical), show your VE (Vitae Essentia) levels
    }

}
