package pneumatter.ritual;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class RitualTechniques extends RitualBase{

    public RitualTechniques(EntityPlayer player, World world, long duration, long fullDuration, BlockPos pos){
        super(player, world, duration, fullDuration, pos);
    }

    @Override
    public void performRitual(EntityPlayer player, World world, BlockPos pos) {
        if(getTimeElapsed() == getDuration()){
            applyEffects(player, world);
            castSpell(player, world);
        }
        super.performRitual(player, world, pos);
    }

    @Override
    public EnumRitualLevel getLevel() {
        return EnumRitualLevel.PRIMAL;
    }

}
