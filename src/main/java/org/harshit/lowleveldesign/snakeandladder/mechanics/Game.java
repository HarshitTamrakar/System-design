package org.harshit.lowleveldesign.snakeandladder.mechanics;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.harshit.lowleveldesign.snakeandladder.model.Dice;
import org.harshit.lowleveldesign.snakeandladder.model.JumpEntity;
import org.harshit.lowleveldesign.snakeandladder.model.Ladder;
import org.harshit.lowleveldesign.snakeandladder.model.Player;
import org.harshit.lowleveldesign.snakeandladder.model.PlayerInput;
import org.harshit.lowleveldesign.snakeandladder.model.Snake;

public class Game {

    private final List<Player> players;
    private final Dice dice;
    private final Map<Integer, JumpEntity> board;
    private final int boardSize;
    private int currentPlayerIndex;
    private final int difficulty;
    private boolean gameOver;

    public Game(int boardSize, List<PlayerInput> playerInputs, int numberOfDices, int difficulty) {
        this.dice = new Dice(numberOfDices);
        this.players = new LinkedList<>();
        this.boardSize = boardSize;
        this.difficulty = difficulty;
        this.gameOver = false;
        this.currentPlayerIndex = 0;
        for (PlayerInput input : playerInputs) {
            this.players.add(new Player(0, input.getType(), input.getName()));
        }
        this.board = new HashMap<>();
        this.board.put(boardSize, null);
        generateGameBoard();
    }

    private void generateGameBoard() {
        Random random = new Random();
        for (int snake = 0; snake < difficulty; snake++) {
            int snakeStartPosition = random.nextInt(boardSize);
            while (board.containsKey(snakeStartPosition)) {
                snakeStartPosition = random.nextInt(boardSize);
            }
            int snakeEndPosition = random.nextInt(snakeStartPosition);
            board.put(snakeStartPosition, new Snake(snakeStartPosition, snakeEndPosition));
        }

        for (int ladder = 0; ladder < (difficulty / 2); ladder++) {
            int ladderStartPosition = random.nextInt(boardSize);
            while (board.containsKey(ladderStartPosition)) {
                ladderStartPosition = random.nextInt(boardSize);
            }
            int ladderEndPosition =
                random.nextInt(boardSize - ladderStartPosition) + ladderStartPosition;
            board.put(ladderStartPosition, new Ladder(ladderStartPosition, ladderEndPosition));
        }
    }

    public void play() {
        System.out.println("Starting game with board " + board);
        while (!gameOver) {
            Player currentPlayer = players.get(currentPlayerIndex);
            int rolled = dice.roll();
            if (currentPlayer.getPosition() + rolled <= boardSize) {
                currentPlayer.move(rolled);
            }
            if (board.containsKey(currentPlayer.getPosition())) {
                JumpEntity jumpEntity = board.get(currentPlayer.getPosition());
                if (jumpEntity instanceof Snake) {
                    Snake snake = (Snake) jumpEntity;
                    System.out.println(currentPlayer + " bitten by snake " + snake);
                    currentPlayer.setPosition(snake.getTail());
                } else if (jumpEntity instanceof Ladder) {
                    Ladder ladder = (Ladder) jumpEntity;
                    System.out.println(currentPlayer + " climbed the ladder " + ladder);
                    currentPlayer.setPosition(ladder.getEnd());
                }
            }
            if (currentPlayer.getPosition() == boardSize) {
                System.out.println("Player " + currentPlayer + " won the game");
                gameOver = true;
            }
            System.out.println(this);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    @Override
    public String toString() {
        return "Game{" +
            "players=" + players +
            ", gameOver=" + gameOver +
            '}';
    }
}