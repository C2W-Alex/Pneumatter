package pneumatter.vitaeessentia;

import net.minecraft.entity.player.EntityPlayer;

public interface ITweakableFactor {
    void setFactor(EntityPlayer player, int amount);
}
