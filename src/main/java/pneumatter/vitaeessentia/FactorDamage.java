package pneumatter.vitaeessentia;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import pneumatter.castables.AttackDamageCastable;

public class FactorDamage implements IFactor {



    @Override
    public int getFactor(EntityPlayer player) {
        return (int)player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
    }

    @Override
    public void setFactor(EntityPlayer player, int amount) {
        new AttackDamageCastable(player, amount);
    }
}
