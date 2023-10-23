package org.harshit.solid.i.example1.goodexample;

public class Waiter implements WaiterInterface {

    // After segregating interfaces, now waiter and chef does not need to write functionality for
    // unnecessary functions

    @Override
    public void serveCustomers() {
        System.out.println("Serving customers");
    }
}