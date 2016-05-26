package com.gridGame;

/**
 * Created by prashant.gu on 5/26/2016.
 *
 */

public enum PlayerLevel {
    STARTER (1),
    AVERAGE (2),
    GOOD (3),
    EXPERIENCED (4),
    PRO (5);

    private final int playerLevel;

    PlayerLevel(int level) {
        this.playerLevel = level;
    }

    public int getPlayerLevel() {
        return this.playerLevel;
    }
}
