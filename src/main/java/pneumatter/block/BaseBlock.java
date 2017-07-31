package pneumatter.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pneumatter.Pneumatter;
import pneumatter.PneumatterTab;
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
        if(!worldIn.isRemote) {
            new MaxHealthCommitment(playerIn, 8D); //amount is in double and represents half-hearts
        }
        return true;
    }
}
