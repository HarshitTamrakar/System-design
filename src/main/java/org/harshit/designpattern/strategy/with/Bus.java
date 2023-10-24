package org.harshit.designpattern.strategy.with;

public class Bus extends Vehicle {
    public Bus() {
        super(new NormalDrivingStrategy());
    }
}