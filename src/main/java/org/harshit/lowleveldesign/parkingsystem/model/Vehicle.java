package org.harshit.lowleveldesign.parkingsystem.model;

public class Vehicle {

    private final String number;
    private final VehicleType type;
    private final String name;

    public Vehicle(String number, VehicleType type, String name) {
        this.number = number;
        this.type = type;
        this.name = name;
    }

    public VehicleType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
            "number='" + number + '\'' +
            ", type=" + type +
            ", name='" + name + '\'' +
            '}';
    }
}