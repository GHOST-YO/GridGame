package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 */

import java.util.*;

public class Controller {
    public static Player player;
    public static Board board;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        String playerName;

        System.out.print("Enter you name: ");
        playerName = scanner.nextLine();

        player = new Player(playerName);

        /**
         * Board
         */

        int numberOfRows = 5, numberOfCols = 5;

        board = new Board(numberOfRows, numberOfCols);

        for(int i = 0; i < numberOfRows; i++) {
            for(int j = 0; j < numberOfCols; j++) {

                if(board.startLocation(i, j) || board.endLocation(i, j)) {
                    board.setGridCell(i, j, 1);
                    continue;
                }

                int choice = random.nextInt(5);

                if(choice <= 1)
                    board.setGridCell(i, j, 0);
                else
                    board.setGridCell(i, j, 1);
            }
        }

        for(int i = 0; i < numberOfRows; ++i) {
            for(int j = 0; j < numberOfCols; ++j) {
                System.out.print(board.Grid[i][j] + " ");
            }
            System.out.println();
        }


        startGame();
    }

    private static void startGame() {
        while(true) {
            int rowNumber = player.getPlayerRow();
            int colNumber = player.getPlayerCol();

            if(board.winCondition(rowNumber, colNumber) == true)
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

            if(board.isValidLocation(rowNumber, colNumber)) {
                player.setLocation(rowNumber, colNumber);

                System.out.println("OK.. Valid move");
            }
            else {
                System.out.println("Sorry.. Invalid Location");
            }
            System.out.println("Your Current Location - (" + player.getPlayerRow() + ", " + player.getPlayerCol() + ")");
        }
        System.out.println("You Win");
    }
}
