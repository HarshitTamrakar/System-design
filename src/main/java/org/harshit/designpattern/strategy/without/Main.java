package org.harshit.designpattern.strategy.without;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Here we can see, if several child classes have similar functionality which is not common
    // to all children, i.e. cannot be extracted in parent class then code needs to be duplicated
    // like here special driving functionality is duplicated in offRoadCar and Suv, to avoid this
    // condition we use strategy design pattern

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new OffRoadCar());
        vehicles.add(new Bus());
        vehicles.add(new Suv());
        for (Vehicle vehicle : vehicles) {
            vehicle.drive();
        }
    }
}