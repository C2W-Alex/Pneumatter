package pneumatter.ritual.commitment;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pneumatter.commitments.MoveSpeedCommitment;
import pneumatter.ritual.EnumRitualLevel;
import pneumatter.ritual.EnumRitualTypes;
import pneumatter.ritual.RitualBase;
import pneumatter.vitaeessentia.FactorHealth;
import pneumatter.vitaeessentia.VELogicHandler;

import java.util.ArrayList;

public class MoveSpeedRitual extends RitualBase {

    public static final int DURATION = 5*20;
    public static final int FULL_DURATION = 7*20;
    public static final EnumRitualLevel LEVEL = EnumRitualLevel.PRIMAL;
    public static final EnumRitualTypes TYPE = EnumRitualTypes.COMMITMENT;
    public static final int AMOUNT = 4;
    public static final int VECOST = 10*AMOUNT;
    public static final ArrayList<BlockPos> BLOCK_POS = new ArrayList<>();
    public static final ArrayList<Block> BLOCKS = new ArrayList<Block>(){};

    public MoveSpeedRitual(EntityPlayer player, World world, BlockPos pos) {
        super(player, world, pos, DURATION, FULL_DURATION, LEVEL, VECOST, BLOCK_POS, BLOCKS, TYPE);
    }

    @Override
    public void addRequirements(BlockPos pos) {
        BLOCK_POS.add(new BlockPos(pos.getX()+4, pos.getY(), pos.getZ()));
        BLOCK_POS.add(new BlockPos(pos.getX()-4, pos.getY(), pos.getZ()));
        BLOCK_POS.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+4));
        BLOCK_POS.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-4));

        BLOCKS.add(Blocks.EMERALD_BLOCK);
        BLOCKS.add(Blocks.EMERALD_BLOCK);
        BLOCKS.add(Blocks.EMERALD_BLOCK);
        BLOCKS.add(Blocks.EMERALD_BLOCK);
    }



    @Override
    public void applyEffects() {
        VELogicHandler handler = new VELogicHandler();
        handler.distributeVE(player, new FactorHealth(), new MoveSpeedCommitment(super.player, AMOUNT));
    }
}
