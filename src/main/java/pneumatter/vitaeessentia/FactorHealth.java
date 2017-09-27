package pneumatter.vitaeessentia;

import net.minecraft.entity.player.EntityPlayer;
import pneumatter.castables.MaxHealthCastable;

public class FactorHealth implements IFactor {

    @Override
    public int getFactor(EntityPlayer player) {
        return (int)player.getMaxHealth();
    }

    @Override
    public void setFactor(EntityPlayer player, int amount) {
        new MaxHealthCastable(player, amount);
    }
}
