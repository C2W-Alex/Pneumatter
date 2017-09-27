package pneumatter.castables;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import pneumatter.vitaeessentia.UUIDHelper;

public class AttackDamageCastable extends BaseCastable {

    public AttackDamageCastable(EntityPlayer player, int  amount) {
        super(player, SharedMonsterAttributes.ATTACK_DAMAGE, new AttributeModifier(UUIDHelper.ATTACK_DAMAGE.getId(), "maxHealth", amount/(int)player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue(), 1));
    }
}
