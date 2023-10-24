package org.harshit.designpattern.strategy.with;

public class Suv extends Vehicle {
    public Suv() {
        super(new SpecialDrivingStrategy());
    }
}