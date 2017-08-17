package pneumatter.rituals;

import net.minecraft.util.math.BlockPos;

public class RitualCommitment implements IRitualBase {

    public RitualCommitment(){

    }

    @Override
    public Boolean getIsPrimitive() {
        return true;
    }

    @Override
    public EnumRitualList getRitualType() {
        return EnumRitualList.COMMITMENT;
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
