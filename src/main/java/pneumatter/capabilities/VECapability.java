package pneumatter.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import pneumatter.Pneumatter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class VECapability {

    @CapabilityInject(IVECapability.class)
    public static final Capability<IVECapability> VE = null;

    @SubscribeEvent
    public void attachVECap(AttachCapabilitiesEvent<Entity> e){
        if(e.getObject() instanceof EntityPlayer){
            e.addCapability(CapabilityHandler.VE, new VECapProvider());
        }

    }

    public static class VECapProvider implements ICapabilitySerializable<NBTTagCompound> {

        @Override
        public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
            return capability == VE;
        }

        @Nullable
        @Override
        public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
            return capability == VE ? capability.getDefaultInstance() : null;
        }

        @Override
        public NBTTagCompound serializeNBT() {
            return (NBTTagCompound) VE.getStorage().writeNBT(VE, VE.getDefaultInstance(), null);
        }

        @Override
        public void deserializeNBT(NBTTagCompound nbt) {
            VE.getStorage().readNBT(VE, VE.getDefaultInstance(), null, nbt);
        }
    }

    public void register() {
        CapabilityManager.INSTANCE.register(IVECapability.class, new VEStorage(), IVECapImplementation.class);
    }

    public static class IVECapImplementation implements IVECapability{
        public int ve = 50;
        public int veMax = 100;
        public int skill =1;
        public int bonus = 0;
        public int costs = 0;

        @Override
        public int getVE() {
            return ve;
        }

        @Override
        public int getMaxVE() {
            return veMax;
        }

        @Override
        public void addVE(int amount) {
            if(ve + amount <= getMaxVE())
                ve += amount;
            else{
                ve = getMaxVE();
            }
        }

        @Override
        public void removeVE(int amount) {
            if(ve - amount >= 0)
                ve -= amount;
            else{
                ve = 0;
            }
        }

        @Override
        public void setVE(int ve) {
            this.ve = ve;
        }

        @Override
        public void setMaxVE(int veMax) {
            this.veMax = veMax;
        }

        @Override
        public int getSkill() {
            return skill;
        }

        @Override
        public void setSkill(int skill) {
            this.skill = skill;
        }

        @Override
        public int getBonus() {
            return bonus;
        }

        @Override
        public void setBonus(int bonus) {
            this.bonus = bonus;
        }

        @Override
        public int getCosts() {
            return costs;
        }

        @Override
        public void setCosts(int costs) {
            this.costs = costs;
        }
    }

    public static class VEStorage implements Capability.IStorage<IVECapability> {

        @Nullable
        @Override
        public NBTBase writeNBT(Capability<IVECapability> capability, IVECapability instance, EnumFacing side)
        {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setInteger("ve", instance.getVE());
            compound.setInteger("veMax", instance.getMaxVE());
            compound.setInteger("skill", instance.getSkill());
            compound.setInteger("bonus", instance.getBonus());
            compound.setInteger("costs", instance.getCosts());
            return compound;
        }

        @Override
        public void readNBT(Capability<IVECapability> capability, IVECapability instance, EnumFacing side, NBTBase nbt)
        {
            NBTTagCompound compound = (NBTTagCompound)nbt;
            instance.setVE(compound.getInteger("ve"));
            instance.setMaxVE(compound.getInteger("veMax"));
            instance.setSkill(compound.getInteger("skill"));
            instance.setBonus(compound.getInteger("bonus"));
            instance.setCosts(compound.getInteger("costs"));
        }
    }
}
