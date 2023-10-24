package org.harshit.designpattern.strategy.with;

public class OffRoadCar extends Vehicle {


    public OffRoadCar() {
        super(new SpecialDrivingStrategy());
    }
}