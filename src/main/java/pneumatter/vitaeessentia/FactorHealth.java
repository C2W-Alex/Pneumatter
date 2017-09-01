package pneumatter.vitaeessentia;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import pneumatter.attributemodifiers.ModifierApplier;

public class FactorHealth implements IFactor {

    @Override
    public int getFactor(EntityPlayer player) {
        return (int)player.getMaxHealth();
    }

    @Override
    public void setFactor(EntityPlayer player, int amount) {
        ModifierApplier.applyChange(player, SharedMonsterAttributes.MAX_HEALTH, new AttributeModifier(UUIDHelper.MAX_HEALTH.getId(),"maxHealth", amount-20, 0));
    }
}
