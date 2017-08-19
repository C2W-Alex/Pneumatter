package pneumatter.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import pneumatter.Pneumatter;

public class GuiBookOfWisdom extends GuiScreen{

    public static final ResourceLocation bookofwisdom = new ResourceLocation(Pneumatter.MODID, "textures/gui/book_of_wisdom.png");
    public static final ResourceLocation booknodestarter = new ResourceLocation(Pneumatter.MODID, "textures/gui/book_node_starter.png");



    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        ScaledResolution sr = new ScaledResolution(mc);
        mc.renderEngine.bindTexture(bookofwisdom);
        int w = sr.getScaledWidth();
        int h = sr.getScaledHeight();
        drawModalRectWithCustomSizedTexture(0, 0, 0, 0, w, h*23/24, w, h*23/24);
        //looks cool for future copy
        mc.renderEngine.bindTexture(booknodestarter);
        drawModalRectWithCustomSizedTexture(w/2 - h/24, h/2 - h/24, 0, 0, h/12, h/12 , h/12, h/12);
    }
}
