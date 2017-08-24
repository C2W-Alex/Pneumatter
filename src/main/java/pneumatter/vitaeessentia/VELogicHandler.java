package pneumatter.vitaeessentia;

import net.minecraft.entity.player.EntityPlayer;
import pneumatter.capabilities.VECapability;

public class VELogicHandler {

    private HealthTweaker healthTweaker = new HealthTweaker();
    private DamageTweaker damageTweaker = new DamageTweaker();

    int skill = 1; //eventually make capability that holds skill
    int storage = 100; //eventually add it in VE capability
    int bonus = 0; //eventually will be the additions made by armor / curses

    public final int formula(EntityPlayer player) {
        return 3*healthTweaker.getFactor(player)*damageTweaker.getFactor(player) + storage*skill + bonus;
    }

    public void distributeVE(EntityPlayer player){
        player.getCapability(VECapability.VE, null).setMaxVE(formula(player));
    }

    public void makeChange(EntityPlayer player, ILockableFactor factor1, ITweakableFactor factor2){
        factor2.setFactor(player, (player.getCapability(VECapability.VE, null).getMaxVE() - storage*skill - bonus)/factor1.getFactor(player));
    }
}
