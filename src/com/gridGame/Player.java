package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */

class Player {
    private String Playername;
    private Position position;
    private int healthCount;

    Player(String name) {
        this.Playername = name;
        this.position = new Position(0, 0);
        this.healthCount = 10;
    }


    Position getPlayerPosition() {
        return this.position;
    }

    void setLocation(Position newPosition) {
        this.position.setPosition(newPosition.getRowNumber(), newPosition.getColNumber());
    }

    int getPlayerHealth() {
        return this.healthCount;
    }

    void setPlayerHealth(int healthLevel) {
        this.healthCount = healthLevel;
    }

    boolean isPositiveHealth() {
        return this.healthCount >= 0;
    }
}
