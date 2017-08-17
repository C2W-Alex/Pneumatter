package pneumatter.rituals;

import net.minecraft.util.math.BlockPos;

public enum EnumRitualList {

    COMMITMENT(ModRituals.ritualCommitment.getRequiredBlocksByOffset()), CURSE(ModRituals.ritualCurse.getRequiredBlocksByOffset());

    public BlockPos requiredBlocksByOffset[];

    EnumRitualList(BlockPos requiredBlocksByOffset[]){
        this.requiredBlocksByOffset = requiredBlocksByOffset;
    }
}
