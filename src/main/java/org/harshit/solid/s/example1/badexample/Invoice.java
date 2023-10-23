package org.harshit.solid.s.example1.badexample;

public class Invoice {

    // THIS IS AN BAD EXAMPLE WHERE SINGLE RESPONSIBILITY PRINCIPLE IS NOT FOLLOWED
    // Single responsibility states, there should be only one reason for a class to be changed,
    // but below we have multiple reason for modifying this class. For example, if saveToDB logic
    // or printInvoice logic or calculateInvoice logic is changed then this class will be changed.

    private int price;
    private int quantity;

    public int calculateInvoice() {
        return price * quantity;
    }

    public void saveToDB() {
        // logic to save invoice to DB
    }

    public void printInvoice() {
        // logic to print invoice
    }
}