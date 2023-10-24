package org.harshit.designpattern.strategy.with;

public class SpecialDrivingStrategy implements DrivingStrategy{

    @Override
    public void drive() {
        System.out.println("Special driving functionality");
    }
}