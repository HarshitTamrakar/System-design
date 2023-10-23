package org.harshit.lowleveldesign.snakegame.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Snake {

    private final LinkedList<SnakeBlock> snake;

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public Snake(int initialX, int initialY) {
        this.snake = new LinkedList<>();
        snake.add(new SnakeBlock(initialX, initialY));
    }

    public SnakeBlock getHead() {
        return snake.get(0);
    }

    public Set<Coordinate> getCoordinates() {
        Set<Coordinate> coordinates = new HashSet<>();
        for (SnakeBlock snakeBlock : snake) {
            coordinates.add(snakeBlock.coordinate);
        }
        return coordinates;
    }

    public void move(LinkedList<Direction> directions) {
        while (directions.size() > snake.size()) {
            directions.remove(0);
        }
        int directionIndex = directions.size() - 1;
        int snakeIndex = 0;
        while (directionIndex >= 0) {
            Direction currentDirection = directions.get(directionIndex);
            SnakeBlock snakeBlock = snake.get(snakeIndex);
            switch (currentDirection) {
                case UP: {
                    snakeBlock.coordinate.setY(snakeBlock.coordinate.getY() + 1);
                    break;
                }
                case DOWN: {
                    snakeBlock.coordinate.setY(snakeBlock.coordinate.getY() - 1);
                    break;
                }
                case LEFT: {
                    snakeBlock.coordinate.setX(snakeBlock.coordinate.getX() - 1);
                    break;
                }
                case RIGHT: {
                    snakeBlock.coordinate.setX(snakeBlock.coordinate.getX() + 1);
                    break;
                }
            }
            directionIndex--;
            snakeIndex++;
        }
    }

    public void addBlock(Coordinate coordinate) {
        snake.addFirst(new SnakeBlock(coordinate.getX(), coordinate.getY()));
    }

    public int size() {
        return snake.size();
    }

    public static class SnakeBlock {
        private final Coordinate coordinate;

        public SnakeBlock(int x, int y) {
            this.coordinate = new Coordinate(x, y);
        }

        public Coordinate getCoordinate() {
            return coordinate;
        }

        @Override
        public String toString() {
            return "SnakeBlock{" +
                "coordinate=" + coordinate +
                '}';
        }
    }

    @Override
    public String toString() {
        return "Snake{" +
            "snake=" + snake +
            '}';
    }
}