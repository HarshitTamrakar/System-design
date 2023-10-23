package org.harshit.solid.o.example1.goodexample;

public class Calculator {

    // Now this class does not care about operations and need not be updated when new
    // operations are added

    public int performOperation(Operation operation, int number1, int number2) {
        return operation.perform(number1, number2);
    }
}