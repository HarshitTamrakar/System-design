package org.harshit.lowleveldesign.parkingsystem.model;

public class ParkingSlot {

    private final VehicleType vehicleType;
    private boolean isAvailable;
    private Vehicle vehicle;

    public ParkingSlot(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        this.isAvailable = true;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        isAvailable = false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void removeVehicle() {
        this.vehicle = null;
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
            "vehicleType=" + vehicleType +
            ", isAvailable=" + isAvailable +
            ", vehicle=" + vehicle +
            '}';
    }
}