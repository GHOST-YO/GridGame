package com.gridGame;

/**
 * Created by prashant.gu on 5/26/2016.
 *
 */
public enum Obstacles {
    OPEN (0),
    WALL (-1),
    MINE (-2);

    private final int obstacleCost;

    Obstacles(int cost) {
        this.obstacleCost = cost;
    }

    int getObstacleCost() {
        return this.obstacleCost;
    }
}
