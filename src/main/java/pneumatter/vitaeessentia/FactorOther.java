package pneumatter.vitaeessentia;

import net.minecraft.entity.player.EntityPlayer;
import pneumatter.capabilities.VECapability;

public class FactorOther implements IFactor {

    @Override
    public int getFactor(EntityPlayer player) {
        return player.getCapability(VECapability.VE, null).getCosts();
    }

    @Override
    public void setFactor(EntityPlayer player, int amount) {
        player.getCapability(VECapability.VE, null).setCosts(amount);
    }
}
