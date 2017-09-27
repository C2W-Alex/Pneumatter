package pneumatter.ritual;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pneumatter.castables.MaxHealthCastable;
import pneumatter.castables.EnumCastableLevel;
import pneumatter.castables.EnumCastableTypes;
import pneumatter.ritual.RitualBase;
import pneumatter.vitaeessentia.FactorSpeed;
import pneumatter.vitaeessentia.VELogicHandler;

import java.util.ArrayList;


public class MaxHealthRitual extends RitualBase{

    public static final int DURATION = 5*20;
    public static final int FULL_DURATION = 7*20;
    public static final EnumCastableLevel LEVEL = EnumCastableLevel.PRIMAL;
    public static final EnumCastableTypes TYPE = EnumCastableTypes.COMMITMENT;
    public static final int AMOUNT = 4;
    public static final int VECOST = 10*AMOUNT;
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
        VELogicHandler handler = new VELogicHandler();
        handler.distributeVE(super.player, new FactorSpeed(), new MaxHealthCastable(super.player, AMOUNT));
    }
}
