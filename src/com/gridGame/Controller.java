package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */

import java.util.*;

public class Controller {
    private static Game game;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String playerName;

        System.out.print("Enter you name: ");
        playerName = scanner.nextLine();

        /**
         * Game
         */

        int numberOfRows = 6, numberOfCols = 6, health = 10;
        int level = PlayerLevel.AVERAGE.getPlayerLevel();

        game = new Game(numberOfRows, numberOfCols, playerName, health, level);


        for(int i = 0; i < numberOfRows; ++i) {
            for(int j = 0; j < numberOfCols; ++j) {
                System.out.print(game.getGameBoard().getGrid()[i][j] + " ");
            }
            System.out.println();
        }


        startGame();
    }

    private static void startGame() {

        while(true) {

            if(game.getGameStatus() != GameStatus.PLAYING.getValue())
                break;

            String nextMove = scanner.nextLine();

            switch (nextMove) {
                case "w":
                    game.playMove('U');
                    break;
                case "s":
                    game.playMove('D');
                    break;
                case "a":
                    game.playMove('L');
                    break;
                case "d":
                    game.playMove('R');
                    break;
                default:
                    System.out.println("Invalid Keystroke");
            }
        }

        if(game.getGameStatus() == GameStatus.WIN.getValue())
            System.out.println("You Win");
        else
            System.out.println("You Lost");
    }
}
