package portsim.port;

public class ContainerQuay extends Quay {
    private int maxContainers;

    /**
     * @param id
     * @param maxContainers
     */
    public ContainerQuay(int id, int maxContainers) {
        super(id);
        if (maxContainers < 0) throw new IllegalArgumentException();
        this.maxContainers = maxContainers;
    }

    /**
     * @return max containers
     */
    public int getMaxContainers() {
        return maxContainers;
    }

    /**
     * @return representing string
     */
    public String toString() {
        return super.toString() + " - " + maxContainers;
    }
}
