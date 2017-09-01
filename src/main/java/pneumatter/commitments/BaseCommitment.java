package pneumatter.commitments;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import pneumatter.attributemodifiers.ModifierApplier;


public abstract class BaseCommitment {

    EntityPlayer player;
    IAttribute attribute;
    AttributeModifier modifier;

    public BaseCommitment(EntityPlayer player, IAttribute attribute, AttributeModifier modifier){
        this.player = player;
        this.attribute = attribute;
        this.modifier = modifier;
        applyCommitment();
    }

    public EntityPlayer getPlayer(){
        return player;
    }

    public IAttribute getAttribute(){
        return attribute;
    }

    public AttributeModifier getModifier(){
        return modifier;
    }

    public void applyCommitment(){
        ModifierApplier.applyChange(getPlayer(), getAttribute(), getModifier());
    }
}
