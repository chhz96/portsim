package portsim.port;

import portsim.cargo.Cargo;

import java.util.ArrayList;
import java.util.List;

public class Port {
    private String name;
    private List<Cargo> cargo;
    private List<Quay> quays;

    public Port(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Cargo> getCargo() {
        return new ArrayList<>(cargo);
    }

    public List<Quay> getQuays() {
        return new ArrayList<>(quays);
    }

    public void addQuay(Quay quay) {
        quays.add(quay);
    }
}
