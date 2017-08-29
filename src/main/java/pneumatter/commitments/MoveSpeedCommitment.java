package pneumatter.commitments;


import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;

public class MoveSpeedCommitment extends BaseCommitment{

    public MoveSpeedCommitment(EntityPlayer player, int amount){
        super(player, SharedMonsterAttributes.MOVEMENT_SPEED, new AttributeModifier("potion.movementSpeed", amount, 0));
    }
}
