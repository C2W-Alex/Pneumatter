package pneumatter.castables;


import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import pneumatter.vitaeessentia.UUIDHelper;

public class MoveSpeedCastable extends BaseCastable {

    public MoveSpeedCastable(EntityPlayer player, int amount){
        super(player, SharedMonsterAttributes.MOVEMENT_SPEED, new AttributeModifier(UUIDHelper.MOVEMENT_SPEED.getId(),"movementSpeed", amount/((int)(10*player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue())), 1));
    }

}
