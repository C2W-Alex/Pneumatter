package pneumatter.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import pneumatter.Pneumatter;
import pneumatter.PneumatterTab;
import pneumatter.capabilities.VECapability;
import pneumatter.commitments.MaxHealthCommitment;

public class BaseBlock extends Block {

    public BaseBlock(Material material, String name){
        super(material);
        setUnlocalizedName(Pneumatter.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(PneumatterTab.pneumatterTab);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote) {

            BlockPos newpos1 = new BlockPos(pos.getX() + 3, pos.getY(), pos.getZ());
            BlockPos newpos2 = new BlockPos(pos.getX() - 3, pos.getY(), pos.getZ());
            BlockPos newpos3 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 3);
            BlockPos newpos4 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 3);

            if (!(worldIn.getBlockState(newpos1).getBlock() instanceof BaseBlock)) {
                playerIn.sendMessage(new TextComponentString("MISSING BLOCK 1"));
            }
            if (!(worldIn.getBlockState(newpos2).getBlock() instanceof BaseBlock)) {
                playerIn.sendMessage(new TextComponentString("MISSING BLOCK 2"));
            }
            if (!(worldIn.getBlockState(newpos3).getBlock() instanceof BaseBlock)) {
                playerIn.sendMessage(new TextComponentString("MISSING BLOCK 3"));
            }
            if (!(worldIn.getBlockState(newpos4).getBlock() instanceof BaseBlock)) {
                playerIn.sendMessage(new TextComponentString("MISSING BLOCK 4"));
            }
            if (worldIn.getBlockState(newpos1).getBlock() instanceof BaseBlock && worldIn.getBlockState(newpos2).getBlock() instanceof BaseBlock && worldIn.getBlockState(newpos3).getBlock() instanceof BaseBlock && worldIn.getBlockState(newpos4).getBlock() instanceof BaseBlock) {
                playerIn.sendMessage(new TextComponentString("MULTIBLOCK COMPLETE"));
            }

            System.out.println(playerIn.hasCapability(VECapability.VE, null));
            new MaxHealthCommitment(playerIn, 8D);
        }
            return true;
        }

}
