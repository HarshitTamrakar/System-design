package org.harshit.designpattern.strategy.with;

public class Vehicle {

     private final DrivingStrategy drivingStrategy;

    Vehicle(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
    }

    public void drive() {
        drivingStrategy.drive();
    }
}