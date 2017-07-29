package pneumatter.capabilities;

public interface IVECapability {

    int getVE();

    int getMaxVE();

    void addVE(int amount);

    void removeVE(int amount);

    void setVE(int ve);

    void setMaxVE(int ve);

}
