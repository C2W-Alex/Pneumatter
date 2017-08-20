package pneumatter.ritual;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class RitualUtil {

    public static Boolean checkAreBlocksDown(ArrayList<Block> blocks, ArrayList<BlockPos> positions, World world){
        int accurateBlocks = 0;
        for(int x =0; x < blocks.size(); x++){
            if(blocks.get(x) != null && positions.get(x) != null) {
                if (blocks.get(x) == world.getBlockState(positions.get(x)).getBlock()) {
                    accurateBlocks++;
                }
            }
        }
        if(accurateBlocks == blocks.size()){
            System.out.println("YEAH YOUR MOM IS FAT");
            return true;
        }
        System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOO");
        return false;
    }
}
