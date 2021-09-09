package portsim.port;

import portsim.ship.Ship;

public abstract class Quay {
    private int id;
    private Ship ship;

    /**
     * @param id
     */
    protected Quay(int id) {
        this.id = id;
        this.ship = null;

        if (id < 0) throw new IllegalArgumentException();
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * @return is quay empty
     */
    public boolean isEmpty() {
        return ship == null;
    }

    /**
     * @param ship
     */
    public void shipArrives(Ship ship) {
        this.ship = ship;
    }

    /**
     * @return the departing ship
     */
    public Ship shipDeparts() {
        Ship ship = this.ship;
        this.ship = null;
        return ship;
    }

    /**
     * @return representing string
     */
    public String toString() {
        return this.getClass().getSimpleName() + " " + id + " [Ship: " + (ship == null ? "None" : ship.getImoNumber()) + "]";
    }
}
