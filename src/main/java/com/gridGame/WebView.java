package com.gridGame;

import org.codehaus.jackson.annotate.JsonAutoDetect;
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

    public WebView() {

    }

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

        System.out.println(playerMessage.gameStatus);
        System.out.println(playerMessage.moveStatus);
        System.out.println(playerMessage.player.getPlayerHealth());
        System.out.println("(" + playerMessage.player.getPlayerPosition().getRowNumber() + ", "
                + playerMessage.player.getPlayerPosition().getColNumber() + ")");

        return playerMessage;
    }

    /*@RequestMapping(value="/{id}/**")
    public String newName(@PathVariable("id") String id, HttpServletRequest request) {
        String path = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String bestMatchPattern = (String ) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);

        AntPathMatcher apm = new AntPathMatcher();
        String finalPath = apm.extractPathWithinPattern(bestMatchPattern, path);

        playerName = finalPath;

        return finalPath;
    }*/
}
