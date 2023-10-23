package org.harshit.lowleveldesign.snakegame.mechanics;

import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

import org.harshit.lowleveldesign.snakegame.model.Coordinate;
import org.harshit.lowleveldesign.snakegame.model.Fruit;
import org.harshit.lowleveldesign.snakegame.model.Snake;
import org.harshit.lowleveldesign.snakegame.model.Snake.Direction;

public class SnakeGame {

    private final LinkedList<Direction> directions;
    private final Snake snake;
    private final int boardSize;
    private final Random randomGenerator;
    private boolean gameOver;
    private int score;
    private Fruit fruit;

    public SnakeGame(int boardSize, int initialX, int initialY) {
        this.snake = new Snake(initialX, initialY);
        this.gameOver = false;
        this.boardSize = boardSize;
        this.randomGenerator = new Random();
        this.directions = new LinkedList<>();
        this.score = 0;
        generateFruit();
    }

    private void generateFruit() {
        Set<Coordinate> coordinates = snake.getCoordinates();
        int x = randomGenerator.nextInt(boardSize);
        int y = randomGenerator.nextInt(boardSize);
        Coordinate coordinate = new Coordinate(x, y);
        while (coordinates.contains(coordinate)) {
            x = randomGenerator.nextInt(boardSize);
            y = randomGenerator.nextInt(boardSize);
            coordinate = new Coordinate(x, y);
        }
        fruit = new Fruit(x, y);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void moveSnake(Direction direction) {
        // todo: logic fro newly added snake block is not working properly
        directions.add(direction);
        snake.move(directions);
        Snake.SnakeBlock head = snake.getHead();
        Coordinate headCoordinate = head.getCoordinate();
        if (headCoordinate.equals(fruit.getCoordinate())) {
            System.out.println("Fruit eaten");
            snake.addBlock(fruit.getCoordinate());
            score++;
            generateFruit();
        } else if (headCoordinate.getX() == -1 || headCoordinate.getX() == boardSize
            || headCoordinate.getY() == -1 || headCoordinate.getY() == boardSize) {
            System.out.println("Player lost, score: " + score);
            gameOver = true;
        } else if (snake.size() == boardSize) {
            System.out.println("Player won");
            gameOver = true;
        }
    }

    @Override
    public String toString() {
        return "SnakeGame{" +
            "directions=" + directions +
            ", snake=" + snake +
            ", gameOver=" + gameOver +
            ", score=" + score +
            ", fruit=" + fruit +
            '}';
    }
}