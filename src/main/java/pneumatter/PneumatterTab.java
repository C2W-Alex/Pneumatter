package pneumatic.matter.proxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class PneumaticMatterTab{
    public static final CreativeTabs pneumaticMatterTab = new CreativeTabs("pneumaticMatterTab") {
        @Override public ItemStack getTabIconItem() {
            return new ItemStack(Items.DIAMOND);
        }
    };
}
