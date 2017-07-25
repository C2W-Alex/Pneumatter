package pneumatter.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import pneumatter.Pneumatter;
import pneumatter.PneumatterTab;

public class BaseBlock extends Block {

    public BaseBlock(Material material, String name){
        super(material);
        setUnlocalizedName(Pneumatter.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(PneumatterTab.pneumatterTab);
    }
}
