package pneumatter.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;
import java.util.concurrent.Callable;

public class VECapability {

    @CapabilityInject(IVECapability.class)
    public static Capability<IVECapability> VE = null;

    public void register()
    {
        CapabilityManager.INSTANCE.register(IVECapability.class, new VEStorage(), IVECapImplementation.class);
    }

    public class IVECapImplementation implements IVECapability{
        public int ve;
        public int veMax;

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
            if(ve + amount <= veMax)
                ve += amount;
            else{
                ve = veMax;
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
    }

    public class VEStorage implements Capability.IStorage<IVECapability> {

        @Nullable
        @Override
        public NBTBase writeNBT(Capability<IVECapability> capability, IVECapability instance, EnumFacing side)
        {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setInteger("ve", instance.getVE());
            compound.setInteger("veMax", instance.getMaxVE());
            return compound;
        }

        @Override
        public void readNBT(Capability<IVECapability> capability, IVECapability instance, EnumFacing side, NBTBase nbt)
        {
            NBTTagCompound compound = (NBTTagCompound)nbt;
            instance.setVE(compound.getInteger("ve"));
            instance.setMaxVE(compound.getInteger("veMax"));
        }
    }
}
