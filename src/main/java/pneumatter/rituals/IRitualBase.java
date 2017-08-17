package pneumatter.rituals;

import net.minecraft.util.math.BlockPos;

public interface IRitualBase {

    Boolean getIsPrimitive();

    EnumRitualList getRitualType();

    BlockPos[] getRequiredBlocksByOffset();

    Boolean isRitualReady();

    void executeRitual();

    long getDuration();

    long getStartTime();

}
