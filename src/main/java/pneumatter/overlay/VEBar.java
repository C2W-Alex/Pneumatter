package pneumatter.overlay;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.Display;
import pneumatter.Pneumatter;
import pneumatter.network.PacketHandler;
import pneumatter.network.TestPacket;

@Mod.EventBusSubscriber(modid = Pneumatter.MODID)
public class VEBar extends GuiScreen {

    ResourceLocation text = new ResourceLocation("resources/assets/pneumatter/textures/overlays/vebar.png");

    @Mod.EventHandler
    public void barRenderer(RenderGameOverlayEvent e){
        if(e.getType() == RenderGameOverlayEvent.ElementType.CHAT){
            mc.renderEngine.bindTexture(text);
            drawTexturedModalRect(Display.getWidth() - 272, Display.getHeight() -128, 0, 0, 256, 256);
        }
    }

    @SubscribeEvent
    public static void renderOverlayEvent(RenderGameOverlayEvent.Text event) {
        PacketHandler.INSTANCE.sendToServer(new TestPacket());
        //TODO semi-transparent bar on the right side of the screen (vertical), show your VE (Vitae Essentia) levels
    }

}
