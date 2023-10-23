package org.harshit.lowleveldesign.snakegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.harshit.lowleveldesign.snakegame.mechanics.SnakeGame;
import org.harshit.lowleveldesign.snakegame.model.Snake;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        SnakeGame snakeGame = new SnakeGame(10, 0, 0);
        while (!snakeGame.isGameOver()) {
            System.out.println(snakeGame);
            Snake.Direction direction = takeInput(bufferedReader);
            snakeGame.moveSnake(direction);
        }
    }

    private static Snake.Direction takeInput(BufferedReader bufferedReader) throws IOException {
        System.out.print(
            "Enter snake direction: 1. for LEFT, 2. for RIGHT, 3. for UP, 4. for DOWN: ");
        int input = Integer.parseInt(bufferedReader.readLine());
        switch (input) {
            case 1:
                return Snake.Direction.LEFT;
            case 2:
                return Snake.Direction.RIGHT;
            case 3:
                return Snake.Direction.UP;
            case 4:
                return Snake.Direction.DOWN;
            default:
                System.out.println("Invalid input, please input again");
        }
        return takeInput(bufferedReader);
    }
}