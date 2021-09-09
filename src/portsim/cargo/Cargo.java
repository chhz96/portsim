package portsim.cargo;

public abstract class Cargo extends Object {
    private int id;
    private String destination;

    protected Cargo(int id, String destination) {
        this.id = id;
        this.destination = destination;

        if (id < 0) throw new IllegalArgumentException();
    }

    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public String toString() {
        return this.getClass().getSimpleName() + " " + id + " to " + destination;
    }
}
