package portsim.port;

public class ContainerQuay extends Quay {
    private int maxContainers;

    public ContainerQuay(int id, int maxContainers) {
        super(id);
        if (maxContainers < 0) throw new IllegalArgumentException();
        this.maxContainers = maxContainers;
    }

    public int getMaxContainers() {
        return maxContainers;
    }

    public String toString() {
        return super.toString() + " - " + maxContainers;
    }
}
