package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */


public class Board {
    private int numberOfRows;
    private int numberOfCols;

    private CellType[][] grid;

    public Board(int rowCount, int colCount) {
        this.numberOfRows = rowCount;
        this.numberOfCols = colCount;

        this.grid = new CellType[rowCount][colCount];
    }

    public boolean outOfBoard(Position currentPosition) {
        return (currentPosition.getRowNumber() < 0
                || currentPosition.getRowNumber() >= this.numberOfRows
                || currentPosition.getColNumber() < 0
                || currentPosition.getColNumber() >= this.numberOfCols);
    }

    public boolean isStartLocation(Position curPosition) {
        return curPosition.getRowNumber() == 0 && curPosition.getColNumber() == 0;
    }

    public boolean isEndLocation(Position curPosition) {
        return curPosition.getRowNumber() == this.numberOfRows - 1
                && curPosition.getColNumber() == this.numberOfCols - 1;
    }

    public void setGridCell(Position curPosition, CellType value) {
        this.getGrid()[curPosition.getRowNumber()][curPosition.getColNumber()] = value;
    }

    public boolean winCondition(Position curPosition) {
        return isEndLocation(curPosition);
    }

    public CellType[][] getGrid() {
        return this.grid;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfCols() {
        return numberOfCols;
    }
}
