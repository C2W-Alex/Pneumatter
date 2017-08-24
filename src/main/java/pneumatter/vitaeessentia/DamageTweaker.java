package pneumatter.vitaeessentia;

import net.minecraft.entity.player.EntityPlayer;

public class DamageTweaker implements ILockableFactor, ITweakableFactor {

    @Override
    public int getFactor(EntityPlayer player) {
        return 1;       //eventually calculatable
    }

    @Override
    public void setFactor(EntityPlayer player, int amount) {

    }
}
