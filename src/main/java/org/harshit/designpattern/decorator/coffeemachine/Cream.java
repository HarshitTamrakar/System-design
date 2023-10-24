package org.harshit.designpattern.decorator.coffeemachine;

public class Cream extends AddOn {

    private final Coffee baseCoffee;

    public Cream(Coffee baseCoffee) {
        this.baseCoffee = baseCoffee;
    }

    @Override
    public int getCost() {
        return baseCoffee.getCost() + 50;
    }
}