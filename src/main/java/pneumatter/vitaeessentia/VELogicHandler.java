package pneumatter.vitaeessentia;

import net.minecraft.entity.player.EntityPlayer;
import pneumatter.capabilities.VECapability;

public class VELogicHandler {

    int skill = 1; //eventually make capability that holds skill
    int damage = 1; //eventually have it calculatable

    public final int formula(EntityPlayer player) {
        return 3*(int)player.getMaxHealth()*skill*damage;
    }

    public void distributeVE(EntityPlayer player){
        player.getCapability(VECapability.VE, null).setMaxVE(formula(player));
    }
}
