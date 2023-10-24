package org.harshit.designpattern.decorator.coffeemachine;

public class Espresso extends AddOn {

    private final Coffee baseCoffee;

    public Espresso(Coffee baseCoffee) {
        this.baseCoffee = baseCoffee;
    }

    @Override
    public int getCost() {
        return baseCoffee.getCost() + 30;
    }
}