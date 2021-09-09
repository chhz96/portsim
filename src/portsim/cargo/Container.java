package portsim.cargo;

public class Container extends Cargo {
    private ContainerType type;

    /**
     * @param id
     * @param destination
     * @param type
     */
    public Container(int id, String destination, ContainerType type) {
        super(id, destination);
        this.type = type;
    }

    /**
     * @return container type
     */
    public ContainerType getType() {
        return type;
    }

    /**
     * @return representing string
     */
    public String toString() {
        return super.toString() + " [" + type + "]";
    }
}
