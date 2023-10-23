package org.harshit.solid.o.example1.goodexample;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int addition = calculator.performOperation(new Addition(), 1, 2);
        System.out.println(addition);
    }
}