package Planes;

import java.util.Objects;

abstract public class Plane {
    protected String model;
    private final int maximalSpeed;
    private final int maximalFlightDistance;
    private final int maximalLoadCapacity;

    public Plane(String model, int maximalSpeed, int maximalFlightDistance, int maximalLoadCapacity) {
        this.model = model;
        this.maximalSpeed = maximalSpeed;
        this.maximalFlightDistance = maximalFlightDistance;
        this.maximalLoadCapacity = maximalLoadCapacity;
    }

    public int getMaximalSpeed() {
        return maximalSpeed;
    }

    public int getMaxFlightDistance() {
        return maximalFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return this.maximalLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maximalSpeed +
                ", maxFlightDistance=" + maximalFlightDistance +
                ", maxLoadCapacity=" + maximalLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return maximalSpeed == plane.maximalSpeed &&
                maximalFlightDistance == plane.maximalFlightDistance &&
                maximalLoadCapacity == plane.maximalLoadCapacity &&
                Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maximalSpeed, maximalFlightDistance, maximalLoadCapacity);
    }
}
