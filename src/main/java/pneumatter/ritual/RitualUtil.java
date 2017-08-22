package pneumatter.ritual;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.Iterator;

public class RitualUtil {

    public static ArrayList<RitualBase> ongoingRituals = new ArrayList<>();
    @SubscribeEvent
    public void onWorldTickEvent(TickEvent.WorldTickEvent e){

        Iterator<RitualBase>  it = ongoingRituals.iterator();

        if(!ongoingRituals.isEmpty()) {

            while (it.hasNext()) {
                RitualBase rit = it.next();
                rit.update();
                if (!rit.isStillActive()) {
                    it.remove();
                }
            }
        }
    }
    public static void addNew(RitualBase ritual){
        if(ritual.isRitualReady()) {
            ongoingRituals.add(ritual);
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
