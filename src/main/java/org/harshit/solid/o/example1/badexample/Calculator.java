package org.harshit.solid.o.example1.badexample;

public class Calculator {

    // OPEN CLOSE PRINCIPLE SUGGESTS CLASS SHOULD BE CLOSED FOR MODIFICATION BUT OPEN FOR EXTENSION.
    // Like if we have the following code tested and live on production, and we want to add another
    // operation say multiplication then this class has to be modified which is wrong as this
    // class was already tested and live on production and modification may bring unexpected bugs
    // in it

    public int performAddition(int number1, int number2) {
        return number1 + number2;
    }

    public int performSubtraction(int number1, int number2) {
        return number1 - number2;
    }
}