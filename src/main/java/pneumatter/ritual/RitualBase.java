package pneumatter.ritual;


import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pneumatter.capabilities.VECapability;

import java.util.ArrayList;

public abstract class RitualBase{

    public long startTime;
    public long timeElapsed;
    public long duration;
    public long fullDuration;
    public ArrayList<BlockPos> blockPositions;
    public ArrayList<Block> blocksInOrder;

    public RitualBase(EntityPlayer player, World world, long duration, long fullDuration, BlockPos pos) {
        setDuration(duration);
        setFullDuration(fullDuration);
        start(player, world, pos);
    }

    public Boolean isRitualReady(EntityPlayer player, World world, BlockPos pos) {
        return RitualUtil.checkAreBlocksDown(getRequiredBlocks(player, world, pos), getRequiredBlockPositions(player,world, pos), world);
    }

    public void start(EntityPlayer player, World world, BlockPos pos){
        if(player.getCapability(VECapability.VE, null).getVE() <= getVECost()){
            player.getCapability(VECapability.VE, null).setVE(0);
        }else{
            player.getCapability(VECapability.VE, null).removeVE(getVECost());
        }
        startTime = System.currentTimeMillis();
        if(isRitualReady(player, world, pos)) {
            performRitual(player, world, pos);
        }
    }

    public void performRitual(EntityPlayer player, World world, BlockPos pos) {
        timeElapsed = System.currentTimeMillis() - getStartTime();
        if(!isDone()){
            render(player, world, pos);
        }
    }

    public long getDuration() {
        return duration;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getTimeElapsed(){
        return timeElapsed;
    }

    public long getFullDuration() {
        return fullDuration;
    }

    public void setDuration(long d) {
        duration = d;
    }

    public void setFullDuration(long d) {
        fullDuration = d;
    }

    public Boolean isDone(){
        return timeElapsed > getFullDuration();
    }

    public EnumRitualTypes getRitualType(RitualBase ritualBase){
        if(ritualBase instanceof RitualTechniques){
            return EnumRitualTypes.TECHNIQUE;
        }else if(ritualBase instanceof RitualCurse){
            return EnumRitualTypes.CURSE;
        }else if(ritualBase instanceof RitualCommitment){
            return EnumRitualTypes.COMMITMENT;
        }else{
            return null;
        }
    }

    public ArrayList<Block> getRequiredBlocks(EntityPlayer player, World world, BlockPos pos){
        return blocksInOrder;
    }

    public ArrayList<BlockPos> getRequiredBlockPositions(EntityPlayer player, World world, BlockPos pos){
        return blockPositions;
    }

    public int getVECost(){
        return 0;
    }

    public abstract EnumRitualLevel getLevel();

    public abstract void applySideEffects(EntityPlayer player, World world);

    public abstract void applyEffects(EntityPlayer player, World world);

    public abstract void castSpell(EntityPlayer player, World world);

    public abstract void render(EntityPlayer player, World world, BlockPos pos);

}
