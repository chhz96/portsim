package portsim.movement;

import portsim.cargo.Cargo;

import java.util.List;

public class CargoMovement extends Movement{
    private List<Cargo> cargo;

    /**
     * @param time
     * @param direction
     * @param cargo
     */
    public CargoMovement(long time, MovementDirection direction, List<Cargo> cargo) {
        super(time, direction);
        this.cargo = cargo;

        if (time < 0) throw new IllegalArgumentException();
    }

    /**
     * @return cargo
     */
    public List<Cargo> getCargo() {
        return cargo;
    }

    /**
     * @return representing string
     */
    public String toString() {
        return super.toString() + " involving " + cargo.size() + " piece(s) of cargo";
    }
}
