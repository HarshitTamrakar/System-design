package org.harshit.solid.s.example1.goodexample;

public class Invoice {

    // Now that we have separated responsibilities to classes, there is only one reason for this
    // class to be changed and that is if we change logic for calculate invoice

    private int rate;
    private int quantity;

    public int calculateInvoice() {
        return rate * quantity;
    }
}