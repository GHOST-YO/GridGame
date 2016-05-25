package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 */
public class Board {
    int numberOfRows;
    int numberOfCols;

    int[][] Grid;

    public Board(int rowCount, int colCount) {
        this.numberOfRows = rowCount;
        this.numberOfCols = colCount;

        this.Grid = new int[rowCount][colCount];
    }

    public boolean isValidLocation(int rowNumber, int colNumber) {
        if(rowNumber >= 0 && rowNumber < this.numberOfRows && colNumber >= 0 && colNumber < this.numberOfCols && this.Grid[rowNumber][colNumber] == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean startLocation(int rowNumber, int colNumber) {
        if(rowNumber == 0 && colNumber == 0)
            return true;
        return false;
    }

    public boolean endLocation(int rowNumber, int colNumber) {
        if(rowNumber == this.numberOfRows && colNumber == this.numberOfCols)
            return true;
        return false;
    }

    public void setGridCell(int rowNumber, int colNumber, int value) {
        this.Grid[rowNumber][colNumber] = value;
    }

    public boolean winCondition(int rowNumber, int colNumber) {
        if(rowNumber == this.numberOfRows && colNumber == this.numberOfCols) {
            return true;
        }
        else {
            return false;
        }
    }
}
