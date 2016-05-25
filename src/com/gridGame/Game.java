package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */

import java.util.*;

class Game {
    private Board board;

    Game(int numberOfRows, int numberOfCols) {
        this.board = new Board(numberOfRows, numberOfCols);

        Position curPosition = new Position();

        Random random = new Random();

        for(int i = 0; i < numberOfRows; i++) {
            for(int j = 0; j < numberOfCols; j++) {
                curPosition.setPosition(i, j);

                if(this.board.isStartLocation(curPosition) || this.board.isEndLocation(curPosition)) {
                    this.board.setGridCell(curPosition, 1);
                    continue;
                }

                int choice = random.nextInt(5);

                if(choice <= 1)
                    this.board.setGridCell(curPosition, 0);
                else
                    this.board.setGridCell(curPosition, 1);
            }
        }
    }

    Board getGameBoard() {
        return this.board;
    }
}
