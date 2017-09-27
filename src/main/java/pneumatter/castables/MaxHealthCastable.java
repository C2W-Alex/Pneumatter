package pneumatter.castables;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import pneumatter.vitaeessentia.UUIDHelper;

public class MaxHealthCastable extends BaseCastable {

    public MaxHealthCastable(EntityPlayer player, double amount) {
        super(player, SharedMonsterAttributes.MAX_HEALTH, new AttributeModifier(UUIDHelper.MAX_HEALTH.getId(), "maxHealth", amount/(int)player.getMaxHealth(), 0));
    }
}
