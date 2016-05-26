package com.gridGame;

/**
 * Created by prashant.gu on 5/26/2016.
 *
 */
public enum CellType {
    OPEN (0),
    WALL (-1),
    MINE (-2);

    private final int obstacleCost;

    CellType(int cost) {
        this.obstacleCost = cost;
    }

    int getObstacleCost() {
        return this.obstacleCost;
    }
}
