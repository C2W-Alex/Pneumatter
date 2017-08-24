package pneumatter.vitaeessentia;

import net.minecraft.entity.player.EntityPlayer;
import pneumatter.commitments.MaxHealthCommitment;

public class HealthTweaker implements ILockableFactor, ITweakableFactor {

    @Override
    public int getFactor(EntityPlayer player) {
        return (int)player.getMaxHealth();
    }

    @Override
    public void setFactor(EntityPlayer player, int amount) {
        new MaxHealthCommitment(player, (double)amount);
    }
}
