package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */

class Board {
    private int numberOfRows;
    private int numberOfCols;

    int[][] Grid;

    Board(int rowCount, int colCount) {
        this.numberOfRows = rowCount;
        this.numberOfCols = colCount;

        this.Grid = new int[rowCount][colCount];
    }

    boolean isValidLocation(Position targetPosition) {
        int rowNumber = targetPosition.getRowNumber();
        int colNumber = targetPosition.getColNumber();
        if(rowNumber >= 0 && rowNumber < this.numberOfRows && colNumber >= 0 && colNumber < this.numberOfCols && this.Grid[rowNumber][colNumber] == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    boolean isStartLocation(Position curPosition) {
        if(curPosition.getRowNumber() == 0 && curPosition.getColNumber() == 0)
            return true;
        return false;
    }

    boolean isEndLocation(Position curPosition) {
        if(curPosition.getRowNumber() == this.numberOfRows && curPosition.getColNumber() == this.numberOfCols)
            return true;
        return false;
    }

    void setGridCell(Position curPosition, int value) {
        this.Grid[curPosition.getRowNumber()][curPosition.getColNumber()] = value;
    }

    boolean winCondition(Position curPosition) {
        if(curPosition.getRowNumber() == this.numberOfRows && curPosition.getColNumber() == this.numberOfCols)
            return true;
        else
            return false;
    }
}
