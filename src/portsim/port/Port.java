package portsim.port;

import portsim.cargo.Cargo;

import java.util.ArrayList;
import java.util.List;

public class Port {
    private String name;
    private List<Cargo> cargo;
    private List<Quay> quays;

    /**
     * @param name
     */
    public Port(String name) {
        this.name = name;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return cargo
     */
    public List<Cargo> getCargo() {
        return new ArrayList<>(cargo);
    }

    /**
     * @return quays
     */
    public List<Quay> getQuays() {
        return new ArrayList<>(quays);
    }

    /**
     * @param quay
     */
    public void addQuay(Quay quay) {
        quays.add(quay);
    }
}
