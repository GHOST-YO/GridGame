package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */

class Board {
    private int numberOfRows;
    private int numberOfCols;

    int[][] Grid;

    public Board(int rowCount, int colCount) {
        this.numberOfRows = rowCount;
        this.numberOfCols = colCount;

        this.Grid = new int[rowCount][colCount];
    }

    public boolean isValidLocation(Position targetPosition) {
        int rowNumber = targetPosition.getRowNumber();
        int colNumber = targetPosition.getColNumber();
        if(this.Grid[rowNumber][colNumber] == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean outOfBoard(Position currentPosition) {
        int rowNumber = currentPosition.getRowNumber();
        int colNumber = currentPosition.getColNumber();

        return (rowNumber < 0 || rowNumber >= this.numberOfRows || colNumber < 0 || colNumber >= this.numberOfCols);
    }

    public boolean isStartLocation(Position curPosition) {
        if(curPosition.getRowNumber() == 0 && curPosition.getColNumber() == 0)
            return true;
        return false;
    }

    public boolean isEndLocation(Position curPosition) {
        if(curPosition.getRowNumber() == this.numberOfRows-1 && curPosition.getColNumber() == this.numberOfCols-1)
            return true;
        return false;
    }

    public void setGridCell(Position curPosition, int value) {
        this.Grid[curPosition.getRowNumber()][curPosition.getColNumber()] = value;
    }

    public boolean winCondition(Position curPosition) {
        if(isEndLocation(curPosition))
            return true;
        else
            return false;
    }
}
