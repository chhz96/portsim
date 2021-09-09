package portsim.movement;

public abstract class Movement {
    private long time;
    private MovementDirection direction;

    /**
     * @param time
     * @param direction
     */
    protected Movement(long time, MovementDirection direction) {
        this.time = time;
        this.direction = direction;

        if (time < 0) throw new IllegalArgumentException();
    }

    /**
     * @return time
     */
    public long getTime() {
        return time;
    }

    /**
     * @return direction
     */
    public MovementDirection getDirection() {
        return direction;
    }

    /**
     * @return representing string
     */
    public String toString() {
        return direction + " " + this.getClass().getSimpleName() + " to occur at " + time;
    }
}
