package pneumatter.rituals;


import net.minecraft.entity.player.EntityPlayer;
import pneumatter.capabilities.VECapability;

public abstract class RitualBase{

    public long startTime;
    public long timeElapsed;
    public long duration;
    public long fullDuration;
    public EnumRitualRequirements[] requiredBlocksByOffset;

    public RitualBase(EntityPlayer player){
        start(player);
    }

    public Boolean isRitualReady() {
        return RitualUtil.checkAreBlocksDown(getRequiredBlocksByOffset());
    }

    public void start(EntityPlayer player){
        if(player.getCapability(VECapability.VE, null).getVE() <= getVECost()){
            player.getCapability(VECapability.VE, null).setVE(0);
        }else{
            player.getCapability(VECapability.VE, null).removeVE(getVECost());
        }
        startTime = System.currentTimeMillis();
        if(isRitualReady()) {
            performRitual();
        }
    }

    EnumRitualRequirements[] getRequiredBlocksByOffset(){
        return requiredBlocksByOffset;
    }

    public void performRitual() {
        timeElapsed = System.currentTimeMillis() - getStartTime();
        if(!isDone()){
            render();
        }
    }

    int getVECost(){
        return 0;
    }

    public long getDuration() {
        return duration;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getTimeElapsed(){
        return timeElapsed;
    }

    public void render() {

    }

    public long getFullDuration() {
        return fullDuration;
    }

    public Boolean isDone(){
        return timeElapsed > getFullDuration();
    }

    EnumRitualTypes getRitualType(RitualBase ritualBase){
        if(ritualBase instanceof RitualTechniques){
            return EnumRitualTypes.TECHNIQUE;
        }else if(ritualBase instanceof RitualCurse){
            return EnumRitualTypes.CURSE;
        }else if(ritualBase instanceof RitualCommitment){
            return EnumRitualTypes.COMMITMENT;
        }else{
            return null;
        }
    }
}
