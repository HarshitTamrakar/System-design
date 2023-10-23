package org.harshit.lowleveldesign.parkingsystem.mechanics;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.harshit.lowleveldesign.parkingsystem.model.ParkingFloor;
import org.harshit.lowleveldesign.parkingsystem.model.ParkingSlot;
import org.harshit.lowleveldesign.parkingsystem.model.Ticket;
import org.harshit.lowleveldesign.parkingsystem.model.Vehicle;
import org.harshit.lowleveldesign.parkingsystem.model.VehicleType;

public class ParkingLot {

    private final List<ParkingFloor> parkingFloors;
    private final Map<Vehicle, Ticket> vehicleTicketMap;
    private final Map<Vehicle, ParkingSlot> vehicleParkingSlotMap;
    private double totalAmount;
    private static ParkingLot instance;

    private ParkingLot() {
        parkingFloors = new ArrayList<>();
        vehicleTicketMap = new HashMap<>();
        vehicleParkingSlotMap = new HashMap<>();
        this.totalAmount = 0.0;
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor parkingFloor) {
        parkingFloors.add(parkingFloor);
    }

    public void entry(Vehicle vehicle) {
        if (vehicleTicketMap.containsKey(vehicle)) {
            System.out.println("Vehicle already in, with ticket: " + vehicleTicketMap.get(vehicle));
            return;
        }
        for (ParkingFloor parkingFloor : parkingFloors) {
            Map<VehicleType, List<ParkingSlot>> parkingFloorMap = parkingFloor.getParkingFloorMap();
            for (ParkingSlot parkingSlot : parkingFloorMap.get(vehicle.getType())) {
                if (parkingSlot.isAvailable()) {
                    parkingSlot.setVehicle(vehicle);
                    vehicleTicketMap.put(vehicle, new Ticket(Instant.now(), vehicle.getType()));
                    vehicleParkingSlotMap.put(vehicle, parkingSlot);
                    System.out.println(vehicle + " entered parking lot");
                    return;
                }
            }
        }
        System.out.println("No space available, right now");
    }

    public void exit(Vehicle vehicle) {
        ParkingSlot occupiedSlot = vehicleParkingSlotMap.get(vehicle);
        occupiedSlot.removeVehicle();
        Ticket occupiedTicket = vehicleTicketMap.get(vehicle);
        double priceToPay = occupiedTicket.getAmount();
        totalAmount += priceToPay;
        System.out.println(vehicle + " stayed for " + occupiedTicket.getElapsedTime()
            + " seconds and billing amount for it is: $" + priceToPay);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
            "parkingFloors=" + parkingFloors +
            ", vehicleTicketMap=" + vehicleTicketMap +
            ", vehicleParkingSlotMap=" + vehicleParkingSlotMap +
            '}';
    }
}