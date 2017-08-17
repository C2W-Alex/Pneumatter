package pneumatter.rituals;

import net.minecraft.util.math.BlockPos;

public class RitualCurse implements IRitualBase {

    public RitualCurse() {

    }

    @Override
    public Boolean getIsPrimitive() {
        return true;
    }

    @Override
    public EnumRitualList getRitualType() {
        return EnumRitualList.CURSE;
    }

    @Override
    public BlockPos[] getRequiredBlocksByOffset() {
        return null;
    }

    @Override
    public Boolean isRitualReady() {
        return false;
    }

    @Override
    public void executeRitual() {

    }

    @Override
    public long getDuration() {
        return 0;
    }

    @Override
    public long getStartTime() {
        return 0;
    }
}
