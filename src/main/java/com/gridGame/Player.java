package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */

public class Player {
    private String PlayerName;
    private Position position;
    private int healthCount;
    private int playerLevel;

    public Player(String name, int health, int level) {
        this.PlayerName = name;
        this.position = new Position(0, 0);
        this.healthCount = health;
        this.playerLevel = level;
    }


    public Position getPlayerPosition() {
        return this.position;
    }

    public void setLocation(Position newPosition) {
        this.position.setPosition(newPosition.getRowNumber(), newPosition.getColNumber());
    }

    public int getPlayerHealth() {
        return this.healthCount;
    }

    public void setPlayerHealth(int healthLevel) {
        this.healthCount = healthLevel;
    }

    public boolean isPositiveHealth() {
        return this.healthCount >= 0;
    }

    public int getPlayerLevel() {
        return this.playerLevel;
    }

    public String getPlayerName() {
        return this.PlayerName;
    }
}
