package com.gridGame;

import java.util.Scanner;

/**
 * Created by prashant.gu on 5/26/2016.
 *
 */
public class TerminalView implements InputInterface{

    Scanner scanner = new Scanner(System.in);
    private Game game;

    @Override
    public void startGame() {

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.print("Enter your Health: ");
        int playerHealth = scanner.nextInt();

        System.out.print("Enter your Level(STARTER, PRO, etc: ");
        String playerLevel = scanner.nextLine();

        int level = 0;
        switch (playerLevel) {
            case "STARTER":
                level = 1;
                break;
            case "AVERAGE":
                level = 2;
                break;
            case "GOOD":
                level = 3;
                break;
            case "EXPERIENCED":
                level = 4;
                break;
            case "PRO":
                level = 5;
                break;
        }

        int numberOfRows = 6, numberOfCols = 6;
        game = new Game(numberOfRows, numberOfCols, playerName, playerHealth, level);

        while(true) {

            if(!game.getGameStatus().equals(GameStatus.PLAYING))
                break;

            printPlayerMessage(game.playMove(this.getDirection()));
        }

        printPlayerMessage(new GameMessage(game.getGameStatus(), MoveStatus.OK, game.getPlayer()));
    }

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

    private void printPlayerMessage(GameMessage playerMessage) {
        System.out.println(playerMessage.gameStatus);
        System.out.println(playerMessage.moveStatus);
        System.out.println(playerMessage.player.getPlayerHealth());
        System.out.println("(" + playerMessage.player.getPlayerPosition().getRowNumber() + ", "
                + playerMessage.player.getPlayerPosition().getColNumber() + ")");
    }
}
