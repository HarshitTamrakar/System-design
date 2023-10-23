package org.harshit.solid.s.example1.goodexample;

public class InvoiceDao {

    // Now that we have separated responsibilities to classes, there is only one reason for this
    // class to be changed and that is if we change logic for saving invoice

    public void saveToDB(Invoice invoice) {
        // logic to save invoice to DB here
    }

    public void saveToFile(Invoice invoice) {
        // logic to save invoice to file here
    }
}