package org.harshit.lowleveldesign.snakeandladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.harshit.lowleveldesign.snakeandladder.mechanics.Game;
import org.harshit.lowleveldesign.snakeandladder.model.Player;
import org.harshit.lowleveldesign.snakeandladder.model.PlayerInput;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPlayers = takeIntInput("Enter number of players", bufferedReader);
        List<PlayerInput> playerInputs = new ArrayList<>(numberOfPlayers);
        for (int i = 0; i < numberOfPlayers; i++) {
            int type =
                takeIntInput("For Player " + (i + 1) + ", Enter 1. for USER and 2. COMPUTER player",
                    bufferedReader);
            PlayerInput playerInput;
            if (type == 1) {
                playerInput =
                    new PlayerInput(
                        takeStringInput("Enter name for " + (i + 1) + " user", bufferedReader),
                        Player.Type.USER);
            } else {
                playerInput = new PlayerInput("Player" + (i + 1), Player.Type.COMPUTER);
            }
            playerInputs.add(playerInput);
        }
        Game game = new Game(1000, playerInputs, 5, 200);
        game.play();
    }

    private static String takeStringInput(String stringToDisplay, BufferedReader bufferedReader)
        throws IOException {
        System.out.print(stringToDisplay + ": ");
        return bufferedReader.readLine();
    }

    private static int takeIntInput(String stringToDisplay, BufferedReader bufferedReader)
        throws IOException {
        System.out.print(stringToDisplay + ": ");
        return Integer.parseInt(bufferedReader.readLine());
    }
}