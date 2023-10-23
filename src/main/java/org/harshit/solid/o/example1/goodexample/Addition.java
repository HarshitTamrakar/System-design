package org.harshit.solid.o.example1.goodexample;

public class Addition implements Operation {

    // Now we can extend operation functionality to have n number of operations without affecting
    // calculator class

    @Override
    public int perform(int number1, int number2) {
        return number1 + number2;
    }
}