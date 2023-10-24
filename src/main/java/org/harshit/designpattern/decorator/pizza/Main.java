package org.harshit.designpattern.decorator.pizza;

public class Main {

    public static void main(String[] args) {
        Pizza capsicumPizza = new Capsicum();
        Pizza capAndExtraCheese = new ExtraCheese(capsicumPizza);
        Pizza capAndExtraCheeseAndVeggies = new Veggies(capAndExtraCheese);
        Pizza onion = new Onion();
        System.out.println("Onion price: $" + onion.getCost());
        System.out.println("Capsicum + Extra cheese + Veggies price: $" + capAndExtraCheeseAndVeggies.getCost());
    }
}