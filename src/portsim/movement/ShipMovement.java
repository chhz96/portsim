package portsim.movement;

import portsim.ship.Ship;

public class ShipMovement extends Movement {
    private Ship ship;

    /**
     * @param time
     * @param direction
     * @param ship
     */
    public ShipMovement(long time, MovementDirection direction, Ship ship) {
        super(time, direction);
        this.ship = ship;
    }

    /**
     * @return ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * @return representing string
     */
    public String toString() {
        return super.toString() + " involving the ship " + ship.getName();
    }
}
