package org.harshit.lowleveldesign.tictactoe.mechanics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.harshit.lowleveldesign.tictactoe.model.Board;
import org.harshit.lowleveldesign.tictactoe.model.Player;

public class TicTacToe {

    private final Scanner scanner;
    private final Board board;
    private final Queue<Player> playerQueue;
    private final int boardSize;

    public TicTacToe(int boardSize) {
        this.scanner = new Scanner(System.in);
        Player player1 = takePlayerInput();
        Player player2 = takePlayerInput();
        scanner.nextLine();
        this.boardSize = boardSize;
        this.board = new Board(boardSize);
        this.playerQueue = new LinkedList<>();
        this.playerQueue.add(player1);
        this.playerQueue.add(player2);
    }

    private Player takePlayerInput() {
        System.out.print("Enter player name: ");
        String playerName = scanner.next();
        System.out.print("Enter player symbol: ");
        char symbol = scanner.next().charAt(0);
        return new Player(playerName, symbol);
    }

    public void startGame() {
        int movesCount = 0;
        while (!playerQueue.isEmpty()) {
            System.out.println(board);
            Player currentPlayer = playerQueue.peek();
            int row = takeInput("Enter row number for " + currentPlayer.getName() + ": ") - 1;
            int column = takeInput("Enter column number for " + currentPlayer.getName() + ": ") - 1;
            boolean isSuccess = board.set(row, column, currentPlayer.getSymbol());
            if (isSuccess) {
                movesCount++;
                playerQueue.offer(playerQueue.poll());
            }
            if (movesCount > (boardSize * boardSize)) {
                System.out.println("Game is draw");
                return;
            }
            if (movesCount >= (boardSize * 2) - 1 && checkGame(currentPlayer, row, column)) {
                System.out.println(currentPlayer + " has won the game");
                return;
            }
        }
    }

    private boolean checkGame(Player currentPlayer, int row, int column) {
        String winnerString =
            String.valueOf(currentPlayer.getSymbol()).repeat(Math.max(0, boardSize));
        StringBuilder rowStringBuilder = new StringBuilder();
        StringBuilder columnStringBuilder = new StringBuilder();
        StringBuilder diagonalStringBuilder = new StringBuilder();
        StringBuilder reverseDiagonalStringBuilder = new StringBuilder();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                char currentSymbol = board.get(i, j);
                if (i == row) {
                    rowStringBuilder.append(currentSymbol);
                }
                if (j == column) {
                    columnStringBuilder.append(currentSymbol);
                }
                if (i == j) {
                    diagonalStringBuilder.append(currentSymbol);
                }
                if (i + j == boardSize - 1) {
                    reverseDiagonalStringBuilder.append(currentSymbol);
                }
            }
        }
        return winnerString.contentEquals(rowStringBuilder) || winnerString.contentEquals(
            columnStringBuilder) || winnerString.contentEquals(diagonalStringBuilder)
            || winnerString.contentEquals(reverseDiagonalStringBuilder);
    }

    private int takeInput(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
}