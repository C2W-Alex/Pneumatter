package pneumatter.ritual;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;

public class RitualUtil {

    public static ArrayList<RitualBase> ongoingRituals;

    @SubscribeEvent
    public void onWorldTickEvent(TickEvent e){
        for(RitualBase r: ongoingRituals){
            r.update();
        }
    }

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
            return true;
        }
        return false;
    }
}
