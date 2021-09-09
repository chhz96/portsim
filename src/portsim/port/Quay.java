package portsim.port;

import portsim.ship.Ship;

public abstract class Quay {
    private int id;
    private Ship ship;

    protected Quay(int id) {
        this.id = id;
        this.ship = null;

        if (id < 0) throw new IllegalArgumentException();
    }

    public int getId() {
        return id;
    }

    public Ship getShip() {
        return ship;
    }

    public boolean isEmpty() {
        return ship == null;
    }

    public void shipArrives(Ship ship) {
        this.ship = ship;
    }

    public Ship shipDeparts() {
        Ship ship = this.ship;
        this.ship = null;
        return ship;
    }

    public String toString() {
        return this.getClass().getSimpleName() + " " + id + " [Ship: " + (ship == null ? "None" : ship.getImoNumber()) + "]";
    }
}
