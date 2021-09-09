package portsim.cargo;

public class BulkCargo extends Cargo {
    private int tonnage;
    private BulkCargoType type;

    /**
     * @param id
     * @param destination
     * @param tonnage
     * @param type
     */
    public BulkCargo(int id, String destination, int tonnage, BulkCargoType type) {
        super(id, destination);
        this.tonnage = tonnage;
        this.type = type;

        if (tonnage < 0) throw new IllegalArgumentException();
    }

    /**
     * @return tonnage
     */
    public int getTonnage() {
        return tonnage;
    }

    /**
     * @return cargo type
     */
    public BulkCargoType getType() {
        return type;
    }

    /**
     * @return representing string
     */
    public String toString() {
        return super.toString() + " [" + type + " - " + tonnage + "]";
    }
}
