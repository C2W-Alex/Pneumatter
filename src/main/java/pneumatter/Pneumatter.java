package pneumatic.matter;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import pneumatic.matter.proxy.CommonProxy;


@Mod(modid = PneumaticMatterMain.MODID, name = PneumaticMatterMain.MODNAME, version = PneumaticMatterMain.VERSION, useMetadata = true)
public class PneumaticMatterMain {

    public static final String MODID = "pneumaticmatter";
    public static final String MODNAME = "Pneumatic Matter";
    public static final String VERSION = "0.0.1";

    @SidedProxy(clientSide = "pneumatic.matter.proxy.ClientProxy", serverSide = "pneumatic.matter.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static PneumaticMatterMain instance;

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
