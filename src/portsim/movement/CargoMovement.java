package portsim.movement;

import portsim.cargo.Cargo;

import java.util.List;

public class CargoMovement extends Movement{
    private List<Cargo> cargo;

    public CargoMovement(long time, MovementDirection direction, List<Cargo> cargo) {
        super(time, direction);
        this.cargo = cargo;

        if (time < 0) throw new IllegalArgumentException();
    }

    public List<Cargo> getCargo() {
        return cargo;
    }

    public String toString() {
        return super.toString() + " involving " + cargo.size() + " piece(s) of cargo";
    }
}
