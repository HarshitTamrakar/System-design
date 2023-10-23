package org.harshit.lowleveldesign.parkingsystem.model;

public enum VehicleType {
    SMALL(1.0), MEDIUM(1.5), LARGE(2.0), EXTRA_LARGE(3.0);
    private final double price;

    VehicleType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "VehicleType{" +
            "type=" + this.name() +
            '}';
    }
}