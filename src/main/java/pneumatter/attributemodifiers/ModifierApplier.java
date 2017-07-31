package pneumatter.attributemodifiers;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;

public class ModifierApplier {

    public static void applyChange(EntityPlayer player, IAttribute attribute, AttributeModifier modifier){
        player.getEntityAttribute(attribute).applyModifier(modifier);
    }
}
