package org.harshit.solid.l.example1.goodexample;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Here we have separated engine bike with normal bike, so we can replace object of child i.e
    // . Motorcycle bike with object of parent i.e. EngineBike. Similarly with child class
    // Bicycle can be substituted in place of Bike as it is general class

    public static void main(String[] args) {
        List<Bike> bikeList = new ArrayList<>();
        bikeList.add(new Bicycle());
        bikeList.add(new Motorcycle());
        for (Bike bike : bikeList) {
            bike.getNumberOfWheels();
        }

        List<EngineBike> engineBikeList = new ArrayList<>();
        engineBikeList.add(new Motorcycle());
        // engineBikeList.add(new Bicycle_GoodExample());
        for (EngineBike engineBike : engineBikeList) {
            engineBike.startEngine();
        }
    }
}