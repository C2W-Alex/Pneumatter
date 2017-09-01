package pneumatter.vitaeessentia;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import pneumatter.attributemodifiers.ModifierApplier;

public class FactorSpeed implements IFactor {

    @Override
    public int getFactor(EntityPlayer player) {
        return (int)player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
    }

    @Override
    public void setFactor(EntityPlayer player, int amount) {
        ModifierApplier.applyChange(player, SharedMonsterAttributes.MOVEMENT_SPEED, new AttributeModifier(UUIDHelper.MOVEMENT_SPEED.getId(), "movementSpeed", amount-1, 0));
    }
}
