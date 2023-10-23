package org.harshit.lowleveldesign.snakeandladder.model;

public class Ladder implements JumpEntity{

    private final int start;
    private final int end;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Ladder{" +
            "start=" + start +
            ", end=" + end +
            '}';
    }
}