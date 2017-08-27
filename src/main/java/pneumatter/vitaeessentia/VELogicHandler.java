package pneumatter.vitaeessentia;

import net.minecraft.entity.player.EntityPlayer;
import pneumatter.capabilities.VECapability;

public class VELogicHandler {
    public EntityPlayer player = null;

    public FactorDamage factorDamage = new FactorDamage();
    public FactorHealth factorHealth = new FactorHealth();
    public FactorOther factorOther = new FactorOther();

    public IFactor factorToChange = null;

    public static final int storage = 100;

    int skill = player.getCapability(VECapability.VE, null).getSkill();
    int bonus = player.getCapability(VECapability.VE, null).getBonus();
    int costs = factorOther.getFactor(player);

    private final int total = 4*20*1 + skill*storage + bonus - costs;

    public VELogicHandler(IFactor factorToChange, EntityPlayer player) {
        this.player = player;
        this.factorToChange = factorToChange;
        distributeVE();
    }

    public int amount() {
        if(factorToChange instanceof FactorHealth){
            return (total-bonus-skill*storage+costs)/factorDamage.getFactor(player)*4;
        }else if(factorToChange instanceof FactorDamage){
            return (total-bonus-skill*storage+costs)/factorHealth.getFactor(player)*4;
        }else{
            return factorToChange.getFactor(player);
        }
    }

    public void distributeVE(){
        this.player = player;
        player.getCapability(VECapability.VE, null).setMaxVE(total);
        if(factorToChange != null) {
            factorToChange.setFactor(player, amount());
        }
    }
}
