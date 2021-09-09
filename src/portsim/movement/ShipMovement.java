package portsim.movement;

import portsim.ship.Ship;

public class ShipMovement extends Movement {
    private Ship ship;

    public ShipMovement(long time, MovementDirection direction, Ship ship) {
        super(time, direction);
        this.ship = ship;
    }

    public Ship getShip() {
        return ship;
    }

    public String toString() {
        return super.toString() + " involving the ship " + ship.getName();
    }
}
