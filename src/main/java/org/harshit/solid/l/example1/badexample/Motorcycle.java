package org.harshit.solid.l.example1.badexample;

public class Motorcycle implements Bike {


    @Override
    public void turnOnEngine() {
        System.out.println("Engine started");
    }

    @Override
    public void accelerate() {
        System.out.println("Speed is increased");
    }

    @Override
    public int getNumberOfWheels() {
        return 2;
    }
}
