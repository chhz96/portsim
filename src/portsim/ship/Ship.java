package portsim.ship;

import portsim.cargo.Cargo;
import portsim.port.Quay;

public abstract class Ship {
    private long imoNumber;
    private String name;
    private String originFlag;
    private NauticalFlag flag;

    protected Ship(long imoNumber, String name, String originFlag, NauticalFlag flag) {
        this.imoNumber = imoNumber;
        this.name = name;
        this.originFlag = originFlag;
        this.flag = flag;

        if (imoNumber > 9999999 || imoNumber < 0) throw new IllegalArgumentException();
    }

    abstract boolean canDock(Quay quay);
    abstract boolean canLoad(Cargo cargo);
    abstract void loadCargo(Cargo cargo);

    public long getImoNumber() {
        return imoNumber;
    }

    public String getName() {
        return name;
    }

    public String getOriginFlag() {
        return originFlag;
    }

    public NauticalFlag getFlag() {
        return flag;
    }

    public String toString() {
        return this.getClass().getSimpleName() + " " + name + " from " + originFlag + " [" + flag + "]";
    }
}
