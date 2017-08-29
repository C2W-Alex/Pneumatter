package pneumatter.vitaeessentia;

import net.minecraft.entity.player.EntityPlayer;
import pneumatter.capabilities.VECapability;

public class VELogicHandler {

    public FactorDamage factorDamage = new FactorDamage();
    public FactorHealth factorHealth = new FactorHealth();
    public FactorSpeed factorSpeed = new FactorSpeed();
    public FactorOther factorOther = new FactorOther();

    public static final int storage = 100;

    public int getSkill(EntityPlayer player){
        return player.getCapability(VECapability.VE, null).getSkill();
    }

    public int getBonus(EntityPlayer player){
        return player.getCapability(VECapability.VE, null).getBonus();
    }

    public int getCosts(EntityPlayer player){
        return factorOther.getFactor(player);
    }

    public int getTotal(EntityPlayer player){
        return 4*20*1*1 + getSkill(player)*storage + getBonus(player) - getCosts(player);
    }

    public int amount(EntityPlayer player, IFactor factorToChange) {
        if(factorToChange instanceof FactorHealth){
            return (getTotal(player)-getBonus(player)-getSkill(player)*storage+getCosts(player))/factorDamage.getFactor(player)*factorSpeed.getFactor(player);
        }else if(factorToChange instanceof FactorDamage){
            return (getTotal(player)-getBonus(player)-getSkill(player)*storage+getCosts(player))/factorHealth.getFactor(player)*factorSpeed.getFactor(player);
        }else if(factorToChange instanceof FactorSpeed){
            return (getTotal(player)-getBonus(player)-getSkill(player)*storage+getCosts(player))/factorHealth.getFactor(player)*factorDamage.getFactor(player);
        }else{
            return factorToChange.getFactor(player);
        }
    }

    public void distributeVE(EntityPlayer player, IFactor factorToChange, Object castable){
        if(factorToChange instanceof FactorOther){
            player.getCapability(VECapability.VE, null).setCosts(player.getCapability(VECapability.VE, null).getCosts()+factorToChange.getFactor(player));
        }
        player.getCapability(VECapability.VE, null).setMaxVE(getTotal(player));
        if(player.getCapability(VECapability.VE, null).getMaxVE()<=0){
            player.setDead();
        }
        if(factorToChange != null) {
            factorToChange.setFactor(player, amount(player, factorToChange));
        }
    }
}
