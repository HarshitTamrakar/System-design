package org.harshit.lowleveldesign.parkingsystem.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {

    private final String name;
    private final Map<VehicleType, List<ParkingSlot>> parkingFloorMap;

    public ParkingFloor(String name) {
        this.name = name;
        parkingFloorMap = new HashMap<>();
    }

    public void addParkingSlot(VehicleType vehicleType, ParkingSlot parkingSlot) {
        List<ParkingSlot> slots = parkingFloorMap.getOrDefault(vehicleType, new ArrayList<>());
        slots.add(parkingSlot);
        parkingFloorMap.put(vehicleType, slots);
    }

    public Map<VehicleType, List<ParkingSlot>> getParkingFloorMap() {
        return parkingFloorMap;
    }

    @Override
    public String toString() {
        return "ParkingFloor{" +
            "name='" + name + '\'' +
            ", parkingFloorMap=" + parkingFloorMap +
            '}';
    }
}