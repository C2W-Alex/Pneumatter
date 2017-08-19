package pneumatter.rituals;

import net.minecraft.entity.player.EntityPlayer;

public abstract class RitualTechniques extends RitualBase implements IRitualBase{

    public RitualTechniques(EntityPlayer player){
        super(player);
    }

    @Override
    public void performRitual() {
        if(getTimeElapsed() == getDuration()){
            applyEffects();
            castSpell();
        }
        super.performRitual();
    }

    @Override
    public EnumRitualLevel getLevel() {
        return EnumRitualLevel.PRIMITIVE;
    }

    @Override
    public void applyEffects() {

    }

    @Override
    public void castSpell() {

    }
}
