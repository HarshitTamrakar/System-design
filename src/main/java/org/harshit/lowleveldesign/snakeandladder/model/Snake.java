package org.harshit.lowleveldesign.snakeandladder.model;

public class Snake implements JumpEntity{

    private final int head;
    private final int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public int getTail() {
        return tail;
    }

    @Override
    public String toString() {
        return "Snake{" +
            "head=" + head +
            ", tail=" + tail +
            '}';
    }
}