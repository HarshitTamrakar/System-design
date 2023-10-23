package org.harshit.lowleveldesign.tictactoe.model;

public class Board {

    private final char[][] board;

    public Board(int boardSize) {
        this.board = new char[boardSize][boardSize];
        initializeBoard();
    }

    private void initializeBoard() {
        int boardSize = board.length;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '.';
            }
        }
    }

    public boolean set(int row, int column, char symbol) {
        if (!isValid(row, column) || board[row][column] != '.') {
            System.out.println("Invalid input");
            return false;
        }
        board[row][column] = symbol;
        return true;
    }

    private boolean isValid(int row, int column) {
        return row >= 0 && column >= 0 && row < board.length && column < board.length;
    }

    public char get(int row, int column) {
        return board[row][column];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int boardSize = board.length;
        for (char[] chars : board) {
            for (int j = 0; j < boardSize; j++) {
                stringBuilder.append(chars[j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}