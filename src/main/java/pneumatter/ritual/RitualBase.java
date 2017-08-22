package pneumatter.ritual;


import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import pneumatter.capabilities.VECapability;

import java.util.ArrayList;

public class RitualBase{

    public int durationTicks;
    public int fullDurationTicks;
    public int ticks;

    public EnumRitualLevel level;

    public int veCost;

    public ArrayList<BlockPos> blockPositions;
    public ArrayList<Block> blocksInOrder;

    public EntityPlayer player;
    public World world;
    public BlockPos pos;

    public EnumRitualTypes type;

    public RitualBase(EntityPlayer player, World world, BlockPos pos, int durationTicks, int fullDurationTicks, EnumRitualLevel level, int veCost, ArrayList<BlockPos> blockPositions, ArrayList<Block> blocksInOrder, EnumRitualTypes type) {
        this.player = player;
        this.pos = pos;
        this.world = world;
        setDurationTicks(durationTicks);
        setFullDurationTicks(fullDurationTicks);
        setBlockPositions(blockPositions);
        setBlocksInOrder(blocksInOrder);
        if(!world.isRemote) {
            setLevel(level);
            setVECost(veCost);
            setRitualType(type);
            addRequirements(pos);
            start(player);
        }
    }



    public Boolean isRitualReady() {
        return isRitualInPlace();
    }

    public void start(EntityPlayer player){
        if(player.getCapability(VECapability.VE, null).getVE() <= getVECost()){
            player.getCapability(VECapability.VE, null).setVE(0);
        }else{
            player.getCapability(VECapability.VE, null).removeVE(getVECost());
        }
    }

    public Boolean isStillActive(){
        return isRitualInPlace() && !isDone();
    }

    public void update(){

        if(isStillActive()) {
            setTicks(getTicks()+1);
            if (world.isRemote) {
                render();
            } else {
                if (getTicks() == getDurationTicks()) {
                    apply();
                }
            }
        }
    }

    public void apply(){
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

    public Boolean isRitualInPlace(){
        return RitualUtil.checkAreBlocksDown(getRequiredBlocks(), getRequiredBlockPositions(), world);
    }


    public Boolean isDone(){
        return getTicks() > getFullDurationTicks();
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
        player.sendMessage(new TextComponentString("THIS SHOULD BE A RENDERER METHOD"));
    }

    public void addRequirements(BlockPos pos){}

    public EnumRitualLevel getLevel(){
        return level;
    }

    public ArrayList<Block> getRequiredBlocks(){
        return blocksInOrder;
    }

    public ArrayList<BlockPos> getRequiredBlockPositions(){
        return blockPositions;
    }

    public int getDurationTicks() {
        return durationTicks;
    }

    public int getFullDurationTicks() {
        return fullDurationTicks;
    }

    public int getVECost(){
        return veCost;
    }

    public int getTicks(){
        return ticks;
    }

    public void setDurationTicks(int t) {
        durationTicks = t;
    }

    public void setFullDurationTicks(int t) {
        fullDurationTicks = t;
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

    public void setTicks(int t){
        ticks = t;
    }
}
