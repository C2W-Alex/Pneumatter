package pneumatter.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import pneumatter.Pneumatter;

public class GuiBookOfWisdom extends GuiScreen{

    public static final ResourceLocation bookofwisdom = new ResourceLocation(Pneumatter.MODID, "textures/gui/book_of_wisdom.png");



    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        ScaledResolution sr = new ScaledResolution(mc);
        mc.renderEngine.bindTexture(bookofwisdom);
        drawTexturedModalRect((sr.getScaledWidth())/2, (sr.getScaledHeight() / 2), 0, 0, 256, 256);
    }
}
