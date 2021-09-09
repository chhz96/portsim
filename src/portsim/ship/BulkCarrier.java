package portsim.ship;

import portsim.cargo.BulkCargo;
import portsim.cargo.Cargo;
import portsim.port.BulkQuay;
import portsim.port.Quay;

public class BulkCarrier extends Ship{
    private BulkCargo bulkCargo;
    private int capacity;

    public BulkCarrier(long imoNumber, String name, String originFlag, NauticalFlag flag, int capacity) {
        super(imoNumber, name, originFlag, flag);
        if (capacity < 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        bulkCargo = null;
    }

    public boolean canDock(Quay quay) {
        return quay instanceof BulkQuay && (bulkCargo == null || ((BulkQuay) quay).getMaxTonnage() >= bulkCargo.getTonnage());
    }

    public boolean canLoad(Cargo cargo) {
        return cargo instanceof BulkCargo && ((BulkCargo)cargo).getTonnage() <= capacity && cargo.getDestination().equals(this.getOriginFlag());
    }

    public void loadCargo(Cargo cargo) {
        if (!canLoad(cargo)) throw new IllegalArgumentException();
        this.bulkCargo = (BulkCargo) cargo;
    }

    public BulkCargo getBulkCargo() {
        return bulkCargo;
    }

    public String toString() {
        return super.toString() + " carrying " + (bulkCargo == null ? "nothing" : bulkCargo.getType());
    }
}
