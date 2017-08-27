package pneumatter.vitaeessentia;

import net.minecraft.entity.player.EntityPlayer;

public interface IFactor {
    int getFactor(EntityPlayer player);
    void setFactor(EntityPlayer player, int amount);
}
