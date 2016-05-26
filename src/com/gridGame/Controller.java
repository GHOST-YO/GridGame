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

            if(game.getGameStatus() != 0)
                break;

            String nextMove = scanner.nextLine();

            if(nextMove.equals("w"))
                game.playMove('U');
            else if(nextMove.equals("s"))
                game.playMove('D');
            else if(nextMove.equals("a"))
                game.playMove('L');
            else
                game.playMove('R');
        }

        if(game.getGameStatus() == 1)
            System.out.println("You Win");
        else
            System.out.println("You Lost");
    }
}
