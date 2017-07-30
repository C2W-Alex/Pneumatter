package pneumatter.capabilities;

import net.minecraft.util.ResourceLocation;
import pneumatter.Pneumatter;

public class CapabilityHandler {

    public static VECapability veCapability = new VECapability();
    public static final ResourceLocation VE = new ResourceLocation(Pneumatter.MODID, "ve");

    public static void registerCapabilities(){
        veCapability.register();
    }
}
