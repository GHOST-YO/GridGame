package com.gridGame;

import java.util.Scanner;

/**
 * Created by prashant.gu on 5/26/2016.
 *
 */
public class TerminalView implements InputInterface{

    Scanner scanner = new Scanner(System.in);

    @Override
    public String getPlayerName() {
        System.out.println("Enter player Name");
        return scanner.nextLine();
    }

    @Override
    public Direction getDirection() {
        System.out.print("Enter the direction to move(a,w,s,d): ");
        String dir = scanner.nextLine();

        switch(dir) {
            case "w":
                return Direction.UP;
            case "s":
                return Direction.DOWN;
            case "a":
                return Direction.LEFT;
            case "d":
                return Direction.RIGHT;
            default:
                return Direction.NONE;
        }
    }

    @Override
    public String printPlayerMessage(String playerMessage) {
        System.out.println(playerMessage);
        return "";
    }
}
