package org.harshit.designpattern.strategy.with;

public class NormalDrivingStrategy implements DrivingStrategy{
    @Override
    public void drive() {
        System.out.println("Normal driving functionality");
    }
}