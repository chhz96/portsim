package portsim.ship;

import portsim.cargo.BulkCargo;
import portsim.cargo.Cargo;
import portsim.port.BulkQuay;
import portsim.port.Quay;

public class BulkCarrier extends Ship{
    private BulkCargo bulkCargo;
    private int capacity;

    /**
     * @param imoNumber
     * @param name
     * @param originFlag
     * @param flag
     * @param capacity
     */
    public BulkCarrier(long imoNumber, String name, String originFlag, NauticalFlag flag, int capacity) {
        super(imoNumber, name, originFlag, flag);
        if (capacity < 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        bulkCargo = null;
    }

    /**
     * @param quay
     * @return if the ship can dock at the quay
     */
    public boolean canDock(Quay quay) {
        return quay instanceof BulkQuay && (bulkCargo == null || ((BulkQuay) quay).getMaxTonnage() >= bulkCargo.getTonnage());
    }

    /**
     * @param cargo
     * @return if the ship can load the cargo
     */
    public boolean canLoad(Cargo cargo) {
        return cargo instanceof BulkCargo && ((BulkCargo)cargo).getTonnage() <= capacity && cargo.getDestination().equals(this.getOriginFlag());
    }

    /**
     * @param cargo
     */
    public void loadCargo(Cargo cargo) {
        if (!canLoad(cargo)) throw new IllegalArgumentException();
        this.bulkCargo = (BulkCargo) cargo;
    }

    /**
     * @return the bulk cargo
     */
    public BulkCargo getBulkCargo() {
        return bulkCargo;
    }

    /**
     * @return representing string
     */
    public String toString() {
        return super.toString() + " carrying " + (bulkCargo == null ? "nothing" : bulkCargo.getType());
    }
}
