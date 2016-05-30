package com.gridGame;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by prashant.gu on 5/26/2016.
 *
 */

@Controller
@EnableAutoConfiguration
@ResponseBody
public class WebView extends WebMvcConfigurerAdapter implements InputInterface{

    private Game game;

    @Override
    public void startGame() {
        System.out.println("IN WebView");
        for(int i = 0; i < game.getGameBoard().getNumberOfRows(); ++i) {
            for(int j = 0; j < game.getGameBoard().getNumberOfCols(); ++j) {
                System.out.print(game.getGameBoard().getGrid()[i][j] + " ");
            }
            System.out.println();
        }
    }

    @RequestMapping(value="/name/{playerName}/{playerHealth}/{playerLevel}", produces = "application/json")
    @ResponseBody
    public GameMessage initialize(@PathVariable String playerName,
                                  @PathVariable int playerHealth,
                                  @PathVariable String playerLevel) {
        int numberOfRows = 6, numberOfCols = 6;

        playerLevel = playerLevel.toUpperCase();

        int level = 1;
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

        game = new Game(numberOfRows, numberOfCols, playerName, playerHealth, level);
        return new GameMessage(game.getGameStatus(), MoveStatus.NONE, game.getPlayer());
    }

    @RequestMapping(value="/{dir}", produces = "application/json")
    @ResponseBody
    public GameMessage move(@PathVariable String dir) {

        dir = dir.toUpperCase();
        Direction direction = null;

        switch(dir) {
            case "UP":
                direction = Direction.UP;
                break;
            case "DOWN":
                direction = Direction.DOWN;
                break;
            case "LEFT":
                direction = Direction.LEFT;
                break;
            case "RIGHT":
                direction = Direction.RIGHT;
                break;
        }
        System.out.println(direction);
        GameMessage playerMessage = game.playMove(direction);

        System.out.println(playerMessage.getGameStatus());
        System.out.println(playerMessage.getMoveStatus());
        System.out.println(playerMessage.getPlayer().getPlayerHealth());
        System.out.println("(" + playerMessage.getPlayer().getPlayerPosition().getRowNumber() + ", "
                + playerMessage.getPlayer().getPlayerPosition().getColNumber() + ")");

        return playerMessage;
    }
}
