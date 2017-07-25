package pneumatter.item;

import net.minecraft.item.Item;
import pneumatter.Pneumatter;
import pneumatter.PneumatterTab;

public class BaseItem extends Item {

    public BaseItem(String name){
        setUnlocalizedName(Pneumatter.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(PneumatterTab.pneumatterTab);
    }

}
