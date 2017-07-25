package pneumatter;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import pneumatter.proxy.CommonProxy;


@Mod(modid = Pneumatter.MODID, name = Pneumatter.MODNAME, version = Pneumatter.VERSION, useMetadata = true)
public class Pneumatter {

    public static final String MODID = "pneumatter";
    public static final String MODNAME = "Pneumatter";
    public static final String VERSION = "0.0.1";

    @SidedProxy(clientSide = "pneumatter.proxy.ClientProxy", serverSide = "pneumatter.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Pneumatter instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

}
