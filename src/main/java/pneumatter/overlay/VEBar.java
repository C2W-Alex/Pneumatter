package pneumatter.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.Display;
import pneumatter.Pneumatter;
import pneumatter.network.PacketHandler;
import pneumatter.network.TestPacket;

public class VEBar extends GuiScreen {

    public static final ResourceLocation text = new ResourceLocation(Pneumatter.MODID, "textures/overlays/vebar.png");

    @SubscribeEvent
    public void renderOverlayEvent(RenderGameOverlayEvent event) {
        mc = Minecraft.getMinecraft();
        ScaledResolution sr = new ScaledResolution(mc);
        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
            mc.renderEngine.bindTexture(text);
            drawTexturedModalRect(sr.getScaledWidth() - (150 - 87), 0, 87, 0, 150, 256);
        }
        //TODO semi-transparent bar on the right side of the screen (vertical), show your VE (Vitae Essentia) levels
    }

}
