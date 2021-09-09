package portsim.port;

public class BulkQuay extends Quay {
    private int maxTonnage;

    public BulkQuay(int id, int maxTonnage) {
        super(id);
        if (maxTonnage < 0) throw new IllegalArgumentException();

        this.maxTonnage = maxTonnage;
    }

    public int getMaxTonnage() {
        return maxTonnage;
    }

    public String toString() {
        return super.toString() + " - " + maxTonnage;
    }
}
