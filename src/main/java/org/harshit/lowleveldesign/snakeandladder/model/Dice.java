package org.harshit.lowleveldesign.snakeandladder.model;

import java.util.Random;

public class Dice {

    private final int numberOfDice;
    private final Random randomGenerator;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
        this.randomGenerator = new Random();
    }

    public int roll() {
        return randomGenerator.nextInt((numberOfDice * 6) - 1) + 1;
    }
}