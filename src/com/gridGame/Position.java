package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */
public class Position {
    private int row;
    private int col;

    public Position() {
        this.row = 0;
        this.col = 0;
    }

    public Position(int rowNumber, int colNumber) {
        this.row = rowNumber;
        this.col = colNumber;
    }

    public void setPosition(int rowNumber, int colNumber) {
        this.row = rowNumber;
        this.col = colNumber;
    }

    public int getRowNumber() {
        return this.row;
    }

    public int getColNumber() {
        return this.col;
    }
}
