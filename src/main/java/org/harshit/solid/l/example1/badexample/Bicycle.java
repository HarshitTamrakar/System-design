package org.harshit.solid.l.example1.badexample;

public class Bicycle implements Bike {
    @Override
    public void turnOnEngine() {
        throw new AssertionError("Engine is not supported");
    }

    @Override
    public void accelerate() {
        throw new AssertionError("Acceleration is not supported");
    }

    @Override
    public int getNumberOfWheels() {
        return 2;
    }
}
