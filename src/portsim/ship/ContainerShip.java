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

    /**
     * @param imoNumber
     * @param name
     * @param originFlag
     * @param flag
     * @param capacity
     */
    public ContainerShip(long imoNumber, String name, String originFlag, NauticalFlag flag, int capacity) {
        super(imoNumber, name, originFlag, flag);
        this.capacity = capacity;

        if (capacity < 0) throw new IllegalArgumentException();

        this.containers = new ArrayList<>();
    }

    /**
     * @param quay
     * @return if the ship can dock at the quay
     */
    public boolean canDock(Quay quay) {
        return quay instanceof ContainerQuay && ((ContainerQuay)quay).getMaxContainers() >= containers.size();
    }

    /**
     * @param cargo
     * @return if the ship can load the cargo
     */
    public boolean canLoad(Cargo cargo) {
        return cargo instanceof Container && containers.size() != capacity && cargo.getDestination().equals(getOriginFlag());
    }

    /**
     * @param cargo
     */
    public void loadCargo(Cargo cargo) {
        if (!canLoad(cargo)) throw new IllegalArgumentException();
        this.containers.add((Container) cargo);
    }

    /**
     * @return the cargo
     * @throws NoSuchCargoException
     */
    public List<Container> unloadCargo() throws NoSuchCargoException {
        if (containers.size() == 0) throw new NoSuchCargoException();
        List<Container> containers = this.containers;
        this.containers = new ArrayList<>();
        return containers;
    }

    /**
     * @return cargo
     */
    public List<Container> getCargo() {
        return new ArrayList<>(this.containers);
    }

    /**
     * @return
     */
    public String toString() {
        return super.toString() + " carrying " + containers.size() + " containers";
    }
}
