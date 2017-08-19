package pneumatter.rituals;


import net.minecraft.entity.player.EntityPlayer;

public abstract class RitualCurse extends RitualBase implements IRitualBase {

    public RitualCurse(EntityPlayer player) {
        super(player);
    }

    @Override
    public void performRitual() {
        if(getTimeElapsed() == getDuration()){
            applyEffects();
            applySideEffects();
        }
        super.performRitual();
    }

    @Override
    public EnumRitualLevel getLevel() {
        return EnumRitualLevel.PRIMITIVE;
    }

    @Override
    public void applySideEffects() {

    }

    @Override
    public void applyEffects() {

    }
}
