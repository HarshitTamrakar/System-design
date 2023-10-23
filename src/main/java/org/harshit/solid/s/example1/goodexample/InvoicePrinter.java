package org.harshit.solid.s.example1.goodexample;

public class InvoicePrinter {

    // Now that we have separated responsibilities to classes, there is only one reason for this
    // class to be changed and that is if we change logic for printing invoice

    public static void printInvoice(Invoice invoice) {
        // logic to print invoice here
    }
}