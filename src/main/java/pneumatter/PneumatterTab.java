package pneumatter;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class PneumatterTab{
    public static final CreativeTabs pneumatterTab = new CreativeTabs("pneumatterTab") {
        @Override public ItemStack getTabIconItem() {
            return new ItemStack(Items.DIAMOND);
        }
    };
}
