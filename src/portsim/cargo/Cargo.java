package portsim.cargo;

public abstract class Cargo extends Object {
    private int id;
    private String destination;

    /**
     * @param id
     * @param destination
     */
    protected Cargo(int id, String destination) {
        this.id = id;
        this.destination = destination;

        if (id < 0) throw new IllegalArgumentException();
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @return representing string
     */
    public String toString() {
        return this.getClass().getSimpleName() + " " + id + " to " + destination;
    }
}
