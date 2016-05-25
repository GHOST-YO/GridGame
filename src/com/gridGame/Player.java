package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 */

public class Player {
    String Playername;

    private int currentRow;
    private int currentCol;

    public Player(String name) {
        this.Playername = name;
        this.currentRow = 0;
        this.currentCol = 0;
    }

    public int getPlayerRow() {
        return this.currentRow;
    }

    public int getPlayerCol() {
        return this.currentCol;
    }

    public void setLocation(int rowNumber, int colNumber) {
        this.currentRow = rowNumber;
        this.currentCol = colNumber;
    }
}
