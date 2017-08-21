package pneumatter.ritual.commitment;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pneumatter.commitments.MaxHealthCommitment;
import pneumatter.ritual.EnumRitualLevel;
import pneumatter.ritual.EnumRitualTypes;
import pneumatter.ritual.RitualBase;

import java.util.ArrayList;
import java.util.Arrays;


public class MaxHealthRitual extends RitualBase{

    public static final long DURATION = 5000;
    public static final long FULL_DURATION = 7000;
    public static final EnumRitualLevel LEVEL = EnumRitualLevel.PRIMAL;
    public static final EnumRitualTypes TYPE = EnumRitualTypes.COMMITMENT;
    public static final int VECOST = 20;
    public static final ArrayList<BlockPos> BLOCK_POS = new ArrayList<>();
    public static final ArrayList<Block> BLOCKS = new ArrayList<Block>(){};


    public MaxHealthRitual(EntityPlayer player, World world, BlockPos pos) {
        super(player, world, pos, DURATION, FULL_DURATION, LEVEL, VECOST, BLOCK_POS, BLOCKS, TYPE);
    }

    @Override
    public void addRequirements(BlockPos pos) {
        BLOCK_POS.add(new BlockPos(pos.getX()+4, pos.getY(), pos.getZ()));
        BLOCK_POS.add(new BlockPos(pos.getX()-4, pos.getY(), pos.getZ()));
        BLOCK_POS.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+4));
        BLOCK_POS.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-4));

        BLOCKS.add(Blocks.DIAMOND_BLOCK);
        BLOCKS.add(Blocks.DIAMOND_BLOCK);
        BLOCKS.add(Blocks.DIAMOND_BLOCK);
        BLOCKS.add(Blocks.DIAMOND_BLOCK);
    }

    @Override
    public void applyEffects() {
        new MaxHealthCommitment(super.player, 4D);
    }
}
