package org.harshit.lowleveldesign.snakeandladder.model;

public class Player {

    private int position;
    private final Type type;
    private final String name;

    public Player(int position, Type type, String name) {
        this.position = position;
        this.type = type;
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move(int position) {
        this.position += position;
    }

    public enum Type {
        COMPUTER, USER
    }

    @Override
    public String toString() {
        return "Player{" +
            "position=" + position +
            ", type=" + type +
            ", name='" + name + '\'' +
            '}';
    }
}