package pneumatter.commitments;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import pneumatter.vitaeessentia.VELogicHandler;

public class MaxHealthCommitment extends BaseCommitment{

    public MaxHealthCommitment(EntityPlayer player, double amount) {
        super(player, SharedMonsterAttributes.MAX_HEALTH, new AttributeModifier("potion.healthBoost", amount, 0));
    }
}
