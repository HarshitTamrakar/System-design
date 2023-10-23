package org.harshit.lowleveldesign.snakeandladder.model;

import org.harshit.lowleveldesign.snakeandladder.model.Player.Type;

public class PlayerInput {

    private final String name;
    private final Type type;

    public PlayerInput(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}