package pneumatter.ritual;


import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import pneumatter.capabilities.VECapability;
import pneumatter.castables.EnumCastableLevel;
import pneumatter.castables.EnumCastableTypes;

import java.util.ArrayList;

public class RitualBase{

    public int durationTicks;
    public int fullDurationTicks;
    public int ticks;

    public EnumCastableLevel level;

    public int veCost;

    public Boolean hasStarted;

    public ArrayList<BlockPos> blockPositions;
    public ArrayList<Block> blocksInOrder;

    public EntityPlayer player;
    public World world;
    public BlockPos pos;

    public EnumCastableTypes type;

    public RitualBase(EntityPlayer player, World world, BlockPos pos, int durationTicks, int fullDurationTicks, EnumCastableLevel level, int veCost, ArrayList<BlockPos> blockPositions, ArrayList<Block> blocksInOrder, EnumCastableTypes type) {
        this.player = player;
        this.pos = pos;
        this.world = world;
        setDurationTicks(durationTicks);
        setFullDurationTicks(fullDurationTicks);
        setBlockPositions(blockPositions);
        setBlocksInOrder(blocksInOrder);
        setLevel(level);
        setVECost(veCost);
        setRitualType(type);
        addRequirements(pos);
        start(player);

    }



    public Boolean isRitualReady() {
        return isRitualInPlace();
    }

    public void start(EntityPlayer player){
        if(player.getCapability(VECapability.VE, null).getVE() <= getVECost()){
            player.getCapability(VECapability.VE, null).setVE(0);
        }else{
            player.getCapability(VECapability.VE, null).removeVE(getVECost());
            hasStarted = true;
        }
    }

    public Boolean isStillActive(){
        return isRitualInPlace() && !isDone();
    }

    public void update(){
        if(hasStarted) {
            player.sendMessage(new TextComponentString("TICKS; " + getTicks()));
            if (world.isRemote) {
                render();
            }
            if (isStillActive()) {
                setTicks(getTicks() + 1);
                if (getTicks() == getDurationTicks()) {
                    apply();
                }
            }
        }
    }

    public void apply(){
        if (getRitualType() == EnumCastableTypes.COMMITMENT) {
            applyEffects();
        } else if (getRitualType() == EnumCastableTypes.CURSE) {
            applyEffects();
            applySideEffects();
        } else if (getRitualType() == EnumCastableTypes.TECHNIQUE) {
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

    public EnumCastableTypes getRitualType(){
        return type;
    }

    public void applySideEffects(){

    }

    public void applyEffects(){

    }

    public void castSpell(){

    }
    @SideOnly(Side.CLIENT)
    public void render(){}

    public void addRequirements(BlockPos pos){}

    public EnumCastableLevel getLevel(){
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

    public void setLevel(EnumCastableLevel l) {
        level = l;
    }

    public void setBlockPositions(ArrayList<BlockPos> pos) {
        blockPositions = pos;
    }

    public void setBlocksInOrder(ArrayList<Block> blocks) {
        blocksInOrder = blocks;
    }

    public void setRitualType(EnumCastableTypes t){
        type = t;
    }

    public void setTicks(int t){
        ticks = t;
    }
}
