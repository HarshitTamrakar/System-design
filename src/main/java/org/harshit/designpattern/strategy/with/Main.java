package org.harshit.designpattern.strategy.with;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Now we have implemented strategy design pattern, now we can avoid duplicating code. From
    // the constructor of child classes, we pass the strategy to the parent class which is to be
    // used in that child class.
    // WHEN TO USE:  When classes at same level have duplicate code
    // ADVANTAGES: code reuse, adding of new strategy is as simple as implementing interface and
    // using that object in class

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