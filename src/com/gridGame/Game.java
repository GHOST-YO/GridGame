package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */

import java.util.*;

class Game {
    private Board board;
    private Player player;

    public Game(int numberOfRows, int numberOfCols, String playerName, int health, int level) {
        this.board = new Board(numberOfRows, numberOfCols);
        this.player = new Player(playerName, health, level);

        Position curPosition = new Position();

        Random random = new Random();

        for(int i = 0; i < numberOfRows; i++) {
            for(int j = 0; j < numberOfCols; j++) {
                curPosition.setPosition(i, j);

                if(this.board.isStartLocation(curPosition) || this.board.isEndLocation(curPosition)) {
                    this.board.setGridCell(curPosition, 0);
                    continue;
                }

                int choice = random.nextInt(10);

                if(choice <= 1)
                    this.board.setGridCell(curPosition, -1);
                else if(choice <= 3)
                    this.board.setGridCell(curPosition, -2);
                else
                    this.board.setGridCell(curPosition, 0);
            }
        }
    }

    public Board getGameBoard() {
        return this.board;
    }

    public int getGameStatus() {
        if(!this.player.isPositiveHealth())
            return -1;
        if(this.board.winCondition(this.player.getPlayerPosition()))
            return 1;
        return 0;
    }

    public void playMove(char dir) {
        int currentRow = this.player.getPlayerPosition().getRowNumber();
        int currentCol = this.player.getPlayerPosition().getColNumber();

        Position newPosition = new Position();

        if(dir == 'L')
            newPosition.setPosition(currentRow, currentCol - this.player.getPlayerLevel());
        else if(dir == 'R')
            newPosition.setPosition(currentRow, currentCol + this.player.getPlayerLevel());
        else if(dir == 'U')
            newPosition.setPosition(currentRow - this.player.getPlayerLevel(), currentCol);
        else
            newPosition.setPosition(currentRow + this.player.getPlayerLevel(), currentCol);

        if(this.board.outOfBoard(newPosition)) {
            System.out.println("Out of Board Move.. Please play again");
            return;
        }

        if(this.board.isValidLocation(newPosition)) {
            System.out.println("OK.. Valid Move");
            this.player.setLocation(newPosition);
        }
        else {
            System.out.println("Invalid Move. Lost Health");
            this.player.setPlayerHealth(this.player.getPlayerHealth() + this.board.Grid[newPosition.getRowNumber()][newPosition.getColNumber()]);
        }
        System.out.println("Current Coordinate - (" + this.player.getPlayerPosition().getRowNumber() + ", " + this.player.getPlayerPosition().getColNumber()+ ")" );
        System.out.println("Current Health - " + this.player.getPlayerHealth());
    }
}
