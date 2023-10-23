package org.harshit.solid.l.example1.goodexample;

public class Motorcycle implements EngineBike {
    @Override
    public void accelerate() {
        System.out.println("Speed is increased");
    }

    @Override
    public void startEngine() {
        System.out.println("Engine is started");
    }

    @Override
    public int getNumberOfWheels() {
        return 2;
    }
}
