package portsim.ship;

import portsim.cargo.Cargo;
import portsim.port.Quay;

public abstract class Ship {
    private long imoNumber;
    private String name;
    private String originFlag;
    private NauticalFlag flag;

    /**
     * @param imoNumber
     * @param name
     * @param originFlag
     * @param flag
     */
    protected Ship(long imoNumber, String name, String originFlag, NauticalFlag flag) {
        this.imoNumber = imoNumber;
        this.name = name;
        this.originFlag = originFlag;
        this.flag = flag;

        if (imoNumber > 9999999 || imoNumber < 1000000) throw new IllegalArgumentException();
    }

    /**
     * @param quay
     * @return if the ship can dock at quay
     */
    abstract boolean canDock(Quay quay);

    /**
     * @param cargo
     * @return if the ship can load the cargo
     */
    abstract boolean canLoad(Cargo cargo);

    /**
     * @param cargo
     */
    abstract void loadCargo(Cargo cargo);

    /**
     * @return imo number
     */
    public long getImoNumber() {
        return imoNumber;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return origin flag
     */
    public String getOriginFlag() {
        return originFlag;
    }

    /**
     * @return nautical flag
     */
    public NauticalFlag getFlag() {
        return flag;
    }

    /**
     * @return representing string
     */
    public String toString() {
        return this.getClass().getSimpleName() + " " + name + " from " + originFlag + " [" + flag + "]";
    }
}
