package org.harshit.solid.i.example1.badexample;

public class Waiter implements RestaurantEmployee {

    // Here waiter class is forced to write implementation of unnecessary function which it does
    // not want, Interface segregation suggests, interface should be such that should not
    // implement unnecessary function that they do not need

    @Override
    public void washDishes() {
        // Not waiter's job
    }

    @Override
    public void serveCustomers() {
        System.out.println("Serving customers");
    }

    @Override
    public void cookFood() {
        // Not waiter's job
    }
}
