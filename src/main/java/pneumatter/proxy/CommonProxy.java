package pneumatter.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import pneumatter.Pneumatter;
import pneumatter.block.ModBlocks;
import pneumatter.capabilities.CapabilityHandler;
import pneumatter.capabilities.VECapability;
import pneumatter.gui.GuiHandler;
import pneumatter.item.ModItems;
import pneumatter.network.PacketHandler;
import pneumatter.rituals.ModRituals;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        PacketHandler.registerPackets();
        CapabilityHandler.registerCapabilities();
        MinecraftForge.EVENT_BUS.register(new VECapability());
        NetworkRegistry.INSTANCE.registerGuiHandler(Pneumatter.instance, new GuiHandler());
        ModRituals.register();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        for(Block x: ModBlocks.modBlocks){
            event.getRegistry().register(x);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for(Block x: ModBlocks.modBlocks){
            event.getRegistry().register(new ItemBlock(x).setRegistryName(x.getRegistryName()));
        }
        for(Item x: ModItems.modItems){
            event.getRegistry().register(x);
        }
    }
}
