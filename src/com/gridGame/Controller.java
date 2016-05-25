package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */

import java.util.*;

public class Controller {
    private static Player player;
    private static Game game;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String playerName;

        System.out.print("Enter you name: ");
        playerName = scanner.nextLine();

        player = new Player(playerName);

        /**
         * Game
         */

        int numberOfRows = 5, numberOfCols = 5;

        game = new Game(numberOfRows, numberOfCols);

        for(int i = 0; i < numberOfRows; ++i) {
            for(int j = 0; j < numberOfCols; ++j) {
                System.out.print(game.getGameBoard().Grid[i][j] + " ");
            }
            System.out.println();
        }


        startGame();
    }

    private static void startGame() {
        while(true) {
            int rowNumber = player.getPlayerPosition().getRowNumber();
            int colNumber = player.getPlayerPosition().getColNumber();

            if(game.getGameBoard().winCondition(player.getPlayerPosition()))
                break;

            String nextMove = scanner.nextLine();

            if(nextMove.equals("w"))
                rowNumber--;
            else if(nextMove.equals("s"))
                rowNumber++;
            else if(nextMove.equals("a"))
                colNumber--;
            else
                colNumber++;

            if(game.getGameBoard().isValidLocation(new Position(rowNumber, colNumber))) {
                player.setLocation(new Position(rowNumber, colNumber));

                System.out.println("OK.. Valid move");
            }
            else {
                player.setPlayerHealth(player.getPlayerHealth() - 1);

                System.out.println("Sorry.. Invalid Location(Lost your Health)");
                if(!player.isPositiveHealth()) {
                    System.out.println("No Health Left. You lost");
                    break;
                }
            }
            System.out.println("Your Current Location - (" + player.getPlayerPosition().getRowNumber() + ", " + player.getPlayerPosition().getColNumber() + ")");
            System.out.println("Current Health - " + player.getPlayerHealth());
        }
        if(player.isPositiveHealth())
            System.out.println("You Win");
    }
}
