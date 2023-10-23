package org.harshit.lowleveldesign.snakegame.model;

public class Fruit {

    private final Coordinate coordinate;

    public Fruit(int x, int y) {
        this.coordinate = new Coordinate(x, y);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return "Fruit{" +
            "coordinate=" + coordinate +
            '}';
    }
}