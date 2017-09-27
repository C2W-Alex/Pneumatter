package pneumatter.castables;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;


public abstract class BaseCastable {

    EntityPlayer player;
    IAttribute attribute;
    AttributeModifier modifier;

    public BaseCastable(EntityPlayer player, IAttribute attribute, AttributeModifier modifier){
        this.player = player;
        this.attribute = attribute;
        this.modifier = modifier;
        applyCommitment();

    }

    public BaseCastable(EntityPlayer player){
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
        getPlayer().getEntityAttribute(getAttribute()).applyModifier(getModifier());
    }
}
