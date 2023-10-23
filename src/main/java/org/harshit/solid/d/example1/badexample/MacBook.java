package org.harshit.solid.d.example1.badexample;

public class MacBook {

    // Dependency Inversion suggests, class should not depend on concrete class like
    // WiredKeyboard rather it should depend on interfaces

    private final WiredKeyboard wiredKeyboard;

    public MacBook(WiredKeyboard wiredKeyboard) {
        this.wiredKeyboard = wiredKeyboard;
    }
}