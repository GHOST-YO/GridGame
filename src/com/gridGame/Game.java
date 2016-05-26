package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */

import java.util.*;

public class Game {
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
                    this.board.setGridCell(curPosition, Obstacles.OPEN.getObstacleCost());
                    continue;
                }

                int choice = random.nextInt(10);

                if(choice <= 1)
                    this.board.setGridCell(curPosition, Obstacles.WALL.getObstacleCost());
                else if(choice <= 3)
                    this.board.setGridCell(curPosition, Obstacles.MINE.getObstacleCost());
                else
                    this.board.setGridCell(curPosition, Obstacles.OPEN.getObstacleCost());
            }
        }
    }

    public Board getGameBoard() {
        return this.board;
    }

    public int getGameStatus() {
        if(!this.player.isPositiveHealth())
            return GameStatus.LOST.getValue();
        if(this.board.winCondition(this.player.getPlayerPosition()))
            return GameStatus.WIN.getValue();
        return GameStatus.PLAYING.getValue();
    }

    public void playMove(char dir) {
        int currentRow = this.player.getPlayerPosition().getRowNumber();
        int currentCol = this.player.getPlayerPosition().getColNumber();

        Position newPosition = new Position();

        switch(dir) {
            case 'L':
                newPosition.setPosition(currentRow, currentCol - this.player.getPlayerLevel());
                break;
            case 'R':
                newPosition.setPosition(currentRow, currentCol + this.player.getPlayerLevel());
                break;
            case 'U':
                newPosition.setPosition(currentRow - this.player.getPlayerLevel(), currentCol);
                break;
            default:
                newPosition.setPosition(currentRow + this.player.getPlayerLevel(), currentCol);
        }
        if(this.board.outOfBoard(newPosition)) {
            System.out.println("Out of Board Move.. Please play again");
            return;
        }

        if(this.isValidLocation(this.board.getGrid()[newPosition.getRowNumber()][newPosition.getColNumber()])) {
            System.out.println("OK.. Valid Move");
            this.player.setLocation(newPosition);
        }
        else {
            System.out.println("Invalid Move. Lost Health");
            this.player.setPlayerHealth(this.player.getPlayerHealth() + this.board.getGrid()[newPosition.getRowNumber()][newPosition.getColNumber()]);
        }
        System.out.println("Current Coordinate - (" + this.player.getPlayerPosition().getRowNumber() + ", " + this.player.getPlayerPosition().getColNumber()+ ")" );
        System.out.println("Current Health - " + this.player.getPlayerHealth());
    }

    private boolean isValidLocation(int obstacleCost) {
        return obstacleCost == Obstacles.OPEN.getObstacleCost();
    }
}

enum GameStatus {
    PLAYING (0),
    WIN (1),
    LOST (-1);

    private final int gameStatus;

    GameStatus(int status) {
        this.gameStatus = status;
    }

    public int getValue() {
        return this.gameStatus;
    }
}