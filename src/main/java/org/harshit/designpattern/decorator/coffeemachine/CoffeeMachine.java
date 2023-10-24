package org.harshit.designpattern.decorator.coffeemachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeMachine {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Coffee coffee = null;
        while (coffee == null) {
            int coffeeType = takeInput(bufferedReader, "Enter 1. Water coffee 2. Milk Coffee : ");
            switch (coffeeType) {
                case 1: {
                    coffee = new WaterCoffee();
                    break;
                }
                case 2: {
                    coffee = new MilkCoffee();
                    break;
                }
                default: {
                    System.out.println("Enter valid input");
                    break;
                }
            }
        }

        int addOn = takeInput(bufferedReader, "Enter 1. Espresso 2. Cream 3. Serve : ");
        while (addOn != 3) {
            switch (addOn) {
                case 1: {
                    coffee = new Espresso(coffee);
                    break;
                }
                case 2: {
                    coffee = new Cream(coffee);
                    break;
                }
                default: {
                    System.out.println("Enter valid input");
                    break;
                }
            }
            addOn = takeInput(bufferedReader, "Enter 1. Espresso 2. Cream 3. Serve : ");
        }
        System.out.println("Your coffee is ready, pay amount: " + coffee.getCost());
    }

    public static int takeInput(BufferedReader bufferedReader, String message) throws IOException {
        System.out.print(message);
        return Integer.parseInt(bufferedReader.readLine());
    }
}