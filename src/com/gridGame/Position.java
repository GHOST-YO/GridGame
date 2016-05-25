package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */
class Position {
    private int row;
    private int col;

    Position() {
        this.row = 0;
        this.col = 0;
    }

    Position(int rowNumber, int colNumber) {
        this.row = rowNumber;
        this.col = colNumber;
    }

    void setPosition(int rowNumber, int colNumber) {
        this.row = rowNumber;
        this.col = colNumber;
    }

    int getRowNumber() {
        return this.row;
    }

    int getColNumber() {
        return this.col;
    }
}
