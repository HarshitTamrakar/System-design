package org.harshit.lowleveldesign.parkingsystem;

import static org.harshit.lowleveldesign.parkingsystem.model.VehicleType.EXTRA_LARGE;
import static org.harshit.lowleveldesign.parkingsystem.model.VehicleType.LARGE;
import static org.harshit.lowleveldesign.parkingsystem.model.VehicleType.MEDIUM;
import static org.harshit.lowleveldesign.parkingsystem.model.VehicleType.SMALL;

import org.harshit.lowleveldesign.parkingsystem.mechanics.ParkingLot;
import org.harshit.lowleveldesign.parkingsystem.model.ParkingFloor;
import org.harshit.lowleveldesign.parkingsystem.model.ParkingSlot;
import org.harshit.lowleveldesign.parkingsystem.model.Vehicle;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingFloor groundFloor = new ParkingFloor("Ground floor");
        groundFloor.addParkingSlot(SMALL, new ParkingSlot(SMALL));
        groundFloor.addParkingSlot(SMALL, new ParkingSlot(SMALL));
        groundFloor.addParkingSlot(MEDIUM, new ParkingSlot(MEDIUM));
        groundFloor.addParkingSlot(LARGE, new ParkingSlot(LARGE));
        groundFloor.addParkingSlot(EXTRA_LARGE, new ParkingSlot(EXTRA_LARGE));
        parkingLot.addFloor(groundFloor);

        Vehicle alto = new Vehicle("MP04CA7445", SMALL, "alto");
        Vehicle swift = new Vehicle("MH07TT6655", SMALL, "swift");

        parkingLot.entry(alto);
        parkingLot.entry(swift);
        Thread.sleep(10000);

        parkingLot.exit(alto);
        parkingLot.entry(swift);
        Thread.sleep(5000);

        parkingLot.exit(swift);
        System.out.println("Total revenue generated is $" + parkingLot.getTotalAmount());
    }
}