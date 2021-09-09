package portsim.port;

public class BulkQuay extends Quay {
    private int maxTonnage;

    /**
     * @param id
     * @param maxTonnage
     */
    public BulkQuay(int id, int maxTonnage) {
        super(id);
        if (maxTonnage < 0) throw new IllegalArgumentException();

        this.maxTonnage = maxTonnage;
    }

    /**
     * @return max tonnage
     */
    public int getMaxTonnage() {
        return maxTonnage;
    }

    /**
     * @return representing string
     */
    public String toString() {
        return super.toString() + " - " + maxTonnage;
    }
}
