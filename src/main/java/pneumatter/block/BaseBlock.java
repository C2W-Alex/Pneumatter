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
import pneumatter.ritual.RitualUtil;
import pneumatter.ritual.commitment.MaxHealthRitual;
import pneumatter.ritual.commitment.MoveSpeedRitual;

public class BaseBlock extends Block {

    public BaseBlock(Material material, String name){
        super(material);
        setUnlocalizedName(Pneumatter.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(PneumatterTab.pneumatterTab);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        MoveSpeedRitual rit = new MoveSpeedRitual(playerIn, worldIn, pos);
        RitualUtil.addNew(rit);

        return true;
    }

}
