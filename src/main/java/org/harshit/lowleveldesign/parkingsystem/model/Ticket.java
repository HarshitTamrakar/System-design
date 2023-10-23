package org.harshit.lowleveldesign.parkingsystem.model;

import java.time.Instant;

public class Ticket {

    private final Instant entryTime;
    private Instant exitTime;
    private final VehicleType vehicleType;

    public Ticket(Instant entryTime, VehicleType vehicleType) {
        this.entryTime = entryTime;
        this.vehicleType = vehicleType;
    }

    public double getAmount() {
        this.exitTime = Instant.now();
        double elapsedTime = (double) (exitTime.toEpochMilli() - entryTime.toEpochMilli()) / 1000;
        return vehicleType.getPrice() * elapsedTime;
    }

    public double getElapsedTime() {
        return (double) (exitTime.toEpochMilli() - entryTime.toEpochMilli()) / 1000;
    }

    @Override
    public String toString() {
        return "Ticket{" +
            "entryTime=" + entryTime +
            ", vehicleType=" + vehicleType +
            '}';
    }
}