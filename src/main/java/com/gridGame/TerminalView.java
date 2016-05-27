package com.gridGame;

import java.util.Scanner;

/**
 * Created by prashant.gu on 5/26/2016.
 *
 */
public class TerminalView {
    private Direction direction;
    private String playerMessage;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getPlayerMessage() {
        return playerMessage;
    }

    public void setPlayerMessage(String playerMessage) {
        this.playerMessage = playerMessage;
    }

    TerminalView() {
        this.direction = Direction.NONE;
        this.playerMessage = "EMPTY MESSAGE";
    }

    public void terminalInput() {
        Scanner scanner = new Scanner(System.in);

        String dir = scanner.nextLine();

        switch(dir) {
            case "w":
                this.direction = Direction.UP;
                break;
            case "a":
                this.direction = Direction.LEFT;
                break;
            case "s":
                this.direction = Direction.DOWN;
                break;
            case "d":
                this.direction = Direction.RIGHT;
        }
    }

    public void terminalOutput() {
        System.out.println(this.playerMessage);
    }
}
