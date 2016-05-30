package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */

import java.util.*;

public class Game {
    private Board board;
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public Game(int numberOfRows, int numberOfCols, String playerName, int health, int level) {
        this.board = new Board(numberOfRows, numberOfCols);
        this.player = new Player(playerName, health, level);

        Position curPosition = new Position();

        Random random = new Random();

        for(int i = 0; i < numberOfRows; i++) {
            for(int j = 0; j < numberOfCols; j++) {
                curPosition.setPosition(i, j);

                if(this.board.isStartLocation(curPosition) || this.board.isEndLocation(curPosition)) {
                    this.board.setGridCell(curPosition, CellType.OPEN);
                    continue;
                }

                int choice = random.nextInt(10);

                if(choice <= 1)
                    this.board.setGridCell(curPosition, CellType.WALL);
                else if(choice <= 3)
                    this.board.setGridCell(curPosition, CellType.MINE);
                else
                    this.board.setGridCell(curPosition, CellType.OPEN);
            }
        }
    }

    public Board getGameBoard() {
        return this.board;
    }

    public GameStatus getGameStatus() {
        if(!this.player.isPositiveHealth())
            return GameStatus.LOST;
        if(this.board.winCondition(this.player.getPlayerPosition()))
            return GameStatus.WIN;
        return GameStatus.PLAYING;
    }

    public GameMessage playMove(Direction dir) {
        int currentRow = this.player.getPlayerPosition().getRowNumber();
        int currentCol = this.player.getPlayerPosition().getColNumber();

        Position newPosition = new Position();

        switch(dir) {
            case LEFT:
                newPosition.setPosition(currentRow, currentCol - this.player.getPlayerLevel());
                break;
            case RIGHT:
                newPosition.setPosition(currentRow, currentCol + this.player.getPlayerLevel());
                break;
            case UP:
                newPosition.setPosition(currentRow - this.player.getPlayerLevel(), currentCol);
                break;
            default:
                newPosition.setPosition(currentRow + this.player.getPlayerLevel(), currentCol);
        }

        String returnMessage = "";
        if(this.board.outOfBoard(newPosition)) {
            return new GameMessage(GameStatus.PLAYING, MoveStatus.OUT_OF_BOARD, this.player);
        }

        if(this.isValidLocation(this.board.getGrid()[newPosition.getRowNumber()][newPosition.getColNumber()])) {
            this.player.setLocation(newPosition);
            return new GameMessage(GameStatus.PLAYING, MoveStatus.OK, this.player);
        }
        else {
            this.player.setPlayerHealth(this.player.getPlayerHealth()
                    + this.board.getGrid()[newPosition.getRowNumber()][newPosition.getColNumber()].getObstacleCost());
            return  new GameMessage(GameStatus.PLAYING, MoveStatus.OBSTACLE, this.player);
        }
    }

    private boolean isValidLocation(CellType cellType) {
        return cellType.equals(CellType.OPEN);
    }
}

class GameMessage {
    private GameStatus gameStatus;
    private MoveStatus moveStatus;
    private Player player;

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public MoveStatus getMoveStatus() {
        return moveStatus;
    }

    public void setMoveStatus(MoveStatus moveStatus) {
        this.moveStatus = moveStatus;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public GameMessage(GameStatus gameStatus, MoveStatus moveStatus, Player player) {
        this.gameStatus = gameStatus;
        this.moveStatus = moveStatus;
        this.player = player;
    }
}

enum MoveStatus {
    OK,
    OBSTACLE,
    OUT_OF_BOARD,
    NONE
}

enum GameStatus {
    PLAYING,
    WIN,
    LOST
}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    NONE
}