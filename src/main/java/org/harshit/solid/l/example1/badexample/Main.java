package org.harshit.solid.l.example1.badexample;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // LISKOV SUBSTITUTION STATES, IF CLASS B IS A SUBTYPE OF CLASS A, THEN WE CAN REPLACE OBJECT
    // OF CLASS A WITH CLASS B, but below we can see bike.accelerate() will throw error as
    // Bicycle does not accelerate. Thus violating liskov substitution principle
    public static void main(String[] args) {
        List<Bike> bikeList = new ArrayList<>();
        bikeList.add(new Motorcycle());
        bikeList.add(new Bicycle());
        for (Bike bike : bikeList) {
            bike.accelerate();
        }
    }
}