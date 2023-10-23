package org.harshit.lowleveldesign.tictactoe;

import org.harshit.lowleveldesign.tictactoe.mechanics.TicTacToe;

public class Main{

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(5);
        ticTacToe.startGame();
    }
}