package pneumatter.vitaeessentia;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import pneumatter.castables.MoveSpeedCastable;

public class FactorSpeed implements IFactor {

    @Override
    public int getFactor(EntityPlayer player) {
        return (int)player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
    }

    @Override
    public void setFactor(EntityPlayer player, int amount) {
        new MoveSpeedCastable(player, amount);
    }
}
