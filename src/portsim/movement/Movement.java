package portsim.movement;

public abstract class Movement {
    private long time;
    private MovementDirection direction;

    protected Movement(long time, MovementDirection direction) {
        this.time = time;
        this.direction = direction;

        if (time < 0) throw new IllegalArgumentException();
    }

    public long getTime() {
        return time;
    }

    public MovementDirection getDirection() {
        return direction;
    }

    public String toString() {
        return direction + " " + this.getClass().getSimpleName() + " to occur at " + time;
    }
}
