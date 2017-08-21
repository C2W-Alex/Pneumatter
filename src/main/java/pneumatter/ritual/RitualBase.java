package pneumatter.ritual;


import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pneumatter.capabilities.VECapability;

import java.util.ArrayList;

public class RitualBase{

    public long startTime;
    public long timeElapsed;
    public long duration;
    public long fullDuration;

    public EnumRitualLevel level;

    public int veCost;

    public ArrayList<BlockPos> blockPositions;
    public ArrayList<Block> blocksInOrder;

    public EntityPlayer player;
    public World world;
    public BlockPos pos;

    public EnumRitualTypes type;

    public RitualBase(EntityPlayer player, World world, BlockPos pos, long duration, long fullDuration, EnumRitualLevel level, int veCost, ArrayList<BlockPos> blockPositions, ArrayList<Block> blocksInOrder, EnumRitualTypes type) {
        this.player = player;
        this.pos = pos;
        this.world = world;
        setDuration(duration);
        setFullDuration(fullDuration);
        setLevel(level);
        setVECost(veCost);
        setBlockPositions(blockPositions);
        setBlocksInOrder(blocksInOrder);
        setRitualType(type);
        addRequirements(pos);
        start(player, world, pos);
    }



    public Boolean isRitualReady() {
        return isRitualInPlace();
    }

    public void start(EntityPlayer player, World world, BlockPos pos){
        if(player.getCapability(VECapability.VE, null).getVE() <= getVECost()){
            player.getCapability(VECapability.VE, null).setVE(0);
        }else{
            player.getCapability(VECapability.VE, null).removeVE(getVECost());
        }

        if(isRitualReady()) {
            startTime = System.currentTimeMillis();
        }
    }



    public void update(){

        if(isRitualInPlace() && !isDone()) {
            timeElapsed = System.currentTimeMillis() - getStartTime();
            if(world.isRemote){
                render();
            }
            if(timeElapsed == duration) {
                if (getRitualType() == EnumRitualTypes.COMMITMENT) {
                    applyEffects();
                } else if (getRitualType() == EnumRitualTypes.CURSE) {
                    applyEffects();
                    applySideEffects();
                } else if (getRitualType() == EnumRitualTypes.TECHNIQUE) {
                    applyEffects();
                    castSpell();
                }
            }
        }else{
            if(!world.isRemote) {
                RitualUtil.ongoingRituals.remove(this);
            }
        }
    }

    public Boolean isRitualInPlace(){
        return RitualUtil.checkAreBlocksDown(getRequiredBlocks(), getRequiredBlockPositions(), world);
    }


    public Boolean isDone(){
        return timeElapsed > getFullDuration();
    }

    public EnumRitualTypes getRitualType(){
        return type;
    }

    public void applySideEffects(){

    }

    public void applyEffects(){

    }

    public void castSpell(){

    }

    public void render(){

    }

    public void addRequirements(BlockPos pos){

    }

    public EnumRitualLevel getLevel(){
        return level;
    }

    public ArrayList<Block> getRequiredBlocks(){
        return blocksInOrder;
    }

    public ArrayList<BlockPos> getRequiredBlockPositions(){
        return blockPositions;
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

    public int getVECost(){
        return veCost;
    }

    public void setDuration(long d) {
        duration = d;
    }

    public void setFullDuration(long d) {
        fullDuration = d;
    }

    public void setVECost(int cost){
        veCost = cost;
    }

    public void setLevel(EnumRitualLevel l) {
        level = l;
    }

    public void setBlockPositions(ArrayList<BlockPos> pos) {
        blockPositions = pos;
    }

    public void setBlocksInOrder(ArrayList<Block> blocks) {
        blocksInOrder = blocks;
    }

    public void setRitualType(EnumRitualTypes t){
        type = t;
    }
}
