package pneumatter.rituals;

import net.minecraft.entity.player.EntityPlayer;

public abstract class RitualCommitment extends RitualBase implements IRitualBase {

    public RitualCommitment(EntityPlayer player){
        super(player);
    }

    @Override
    public void performRitual() {
        if(getTimeElapsed() == getDuration()){
            applyEffects();
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
}