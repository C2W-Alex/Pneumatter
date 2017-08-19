package pneumatter.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import pneumatter.Pneumatter;
import pneumatter.capabilities.IVECapability;
import pneumatter.capabilities.VECapability;

public class VEBar extends GuiScreen {

    public static final ResourceLocation text = new ResourceLocation(Pneumatter.MODID, "textures/overlays/ve_bar.png");

    @SubscribeEvent
    public void renderOverlayEvent(RenderGameOverlayEvent event) {
        mc = Minecraft.getMinecraft();
        ScaledResolution sr = new ScaledResolution(mc);
        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
            mc.renderEngine.bindTexture(text);
            GlStateManager.enableAlpha();
            drawTexturedModalRect(sr.getScaledWidth()*31/32 - 19, sr.getScaledHeight()*1/16, 0, 0, 19, 195);

            for(int x = 190; x >= mc.player.getCapability(VECapability.VE, null ).getVE()/mc.player.getCapability(VECapability.VE, null ).getMaxVE()*190;  x--){
                GlStateManager.enableAlpha();
                drawTexturedModalRect(sr.getScaledWidth()*31/32 - 19, sr.getScaledHeight()*1/16 + 2 + x, 19, 2 + x, 19, 1);
            }

        }

    }

}
