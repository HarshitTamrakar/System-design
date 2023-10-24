package org.harshit.designpattern.decorator.coffeemachine;

public class MilkCoffee extends Coffee{

    @Override
    public int getCost() {
        return 150;
    }
}