package portsim.ship;

import portsim.cargo.Cargo;
import portsim.cargo.Container;
import portsim.port.ContainerQuay;
import portsim.port.Quay;
import portsim.util.NoSuchCargoException;

import java.util.ArrayList;
import java.util.List;

public class ContainerShip extends Ship {
    private int capacity;
    private List<Container> containers;

    public ContainerShip(long imoNumber, String name, String originFlag, NauticalFlag flag, int capacity) {
        super(imoNumber, name, originFlag, flag);
        this.capacity = capacity;

        if (capacity < 0) throw new IllegalArgumentException();

        this.containers = new ArrayList<>();
    }

    public boolean canDock(Quay quay) {
        return quay instanceof ContainerQuay && ((ContainerQuay)quay).getMaxContainers() >= containers.size();
    }

    public boolean canLoad(Cargo cargo) {
        return cargo instanceof Container && containers.size() != capacity && cargo.getDestination().equals(getOriginFlag());
    }

    public void loadCargo(Cargo cargo) {
        if (!canLoad(cargo)) throw new IllegalArgumentException();
        this.containers.add((Container) cargo);
    }

    public List<Container> unloadCargo() throws NoSuchCargoException {
        if (containers.size() == 0) throw new NoSuchCargoException();
        List<Container> containers = this.containers;
        this.containers = new ArrayList<>();
        return containers;
    }

    public List<Container> getCargo() {
        return new ArrayList<>(this.containers);
    }

    public String toString() {
        return super.toString() + " carrying " + containers.size() + " containers";
    }
}
