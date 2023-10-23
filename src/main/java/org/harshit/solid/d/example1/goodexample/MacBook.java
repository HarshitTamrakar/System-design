package org.harshit.solid.d.example1.goodexample;

public class MacBook {

    // Now this class does not depend on concrete class WiredKeyboard rather depends on
    // interface so that we can provide any implementation of keyboard to it
    private final Keyboard keyboard;

    public MacBook(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

}