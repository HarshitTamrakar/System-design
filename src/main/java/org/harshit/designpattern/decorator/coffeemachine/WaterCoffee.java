package org.harshit.designpattern.decorator.coffeemachine;

public class WaterCoffee extends Coffee {

    @Override
    public int getCost() {
        return 100;
    }
}