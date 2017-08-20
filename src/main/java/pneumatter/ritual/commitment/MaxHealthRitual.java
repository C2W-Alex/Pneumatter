package pneumatter.ritual.commitment;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pneumatter.commitments.MaxHealthCommitment;
import pneumatter.ritual.RitualCommitment;

import java.util.ArrayList;


public class MaxHealthRitual extends RitualCommitment{

    public static final long DURATION = 5000;
    public static final long FULL_DURATION = 7000;

    public MaxHealthRitual(EntityPlayer player, World world, long duration, long fullDuration, BlockPos pos){
        super(player, world, duration, fullDuration, pos);
    }

    @Override
    public void applySideEffects(EntityPlayer player, World world) {}

    @Override
    public void applyEffects(EntityPlayer player, World world) {
        if(world.isRemote) {
            new MaxHealthCommitment(player, 4D);
        }
    }

    @Override
    public ArrayList<Block> getRequiredBlocks(EntityPlayer player, World world, BlockPos pos) {
        ArrayList<Block> a = new ArrayList<>();
        a.add(Blocks.DIAMOND_BLOCK);
        a.add(Blocks.DIAMOND_BLOCK);
        a.add(Blocks.DIAMOND_BLOCK);
        a.add(Blocks.DIAMOND_BLOCK);
        return a;
    }

    @Override
    public ArrayList<BlockPos> getRequiredBlockPositions(EntityPlayer player, World world, BlockPos pos) {
        ArrayList<BlockPos> a = new ArrayList<>();
        a.add(new BlockPos(pos.getX() + 4, pos.getY(), pos.getZ()));
        a.add(new BlockPos(pos.getX() - 4, pos.getY(), pos.getZ()));
        a.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 4));
        a.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 4));
        return a;
    }

    @Override
    public void castSpell(EntityPlayer player, World world) {}

    @Override
    public void render(EntityPlayer player, World world, BlockPos pos) {

    }
}
