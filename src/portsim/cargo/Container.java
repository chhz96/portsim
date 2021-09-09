package portsim.cargo;

public class Container extends Cargo {
    private ContainerType type;

    public Container(int id, String destination, ContainerType type) {
        super(id, destination);
        this.type = type;
    }

    public ContainerType getType() {
        return type;
    }

    public String toString() {
        return super.toString() + " [" + type + "]";
    }
}
