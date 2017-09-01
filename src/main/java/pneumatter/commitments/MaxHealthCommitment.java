package pneumatter.commitments;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import pneumatter.vitaeessentia.UUIDHelper;

public class MaxHealthCommitment extends BaseCommitment{

    public MaxHealthCommitment(EntityPlayer player, double amount) {
        super(player, SharedMonsterAttributes.MAX_HEALTH, new AttributeModifier(UUIDHelper.MAX_HEALTH.getId(), "maxHealth", amount, 0));
    }
}
