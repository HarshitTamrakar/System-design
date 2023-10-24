package org.harshit.designpattern.decorator.pizza;

public class Veggies extends Topping{

    private final Pizza basePizza;

    public Veggies(Pizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + 30;
    }
}