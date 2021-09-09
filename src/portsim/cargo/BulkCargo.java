package portsim.cargo;

public class BulkCargo extends Cargo {
    private int tonnage;
    private BulkCargoType type;

    public BulkCargo(int id, String destination, int tonnage, BulkCargoType type) {
        super(id, destination);
        this.tonnage = tonnage;
        this.type = type;

        if (tonnage < 0) throw new IllegalArgumentException();
    }

    public int getTonnage() {
        return tonnage;
    }

    public BulkCargoType getType() {
        return type;
    }

    public String toString() {
        return super.toString() + " [" + type + " - " + tonnage + "]";
    }
}
