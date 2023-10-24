package org.harshit.designpattern.decorator.pizza;

public class ExtraCheese extends Topping{

    private final Pizza basePizza;

    public ExtraCheese(Pizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + 20;
    }
}
