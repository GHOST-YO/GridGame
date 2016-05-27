package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import java.util.*;

@SpringBootApplication
public class Controller {
    private static Game game;
    private static Scanner scanner = new Scanner(System.in);
    private static WebView webView = new WebView();
    private static TerminalView terminalView = new TerminalView();


    public static void main(String[] args) {
        SpringApplication.run(Controller.class, args);
        String playerName;

        System.out.print("Enter you name: ");
        playerName = scanner.nextLine();

        /**
         * Game
         */

        int numberOfRows = 6, numberOfCols = 6, health = 10;
        int level = PlayerLevel.AVERAGE.getPlayerLevel();

        game = new Game(numberOfRows, numberOfCols, playerName, health, level);


        for(int i = 0; i < numberOfRows; ++i) {
            for(int j = 0; j < numberOfCols; ++j) {
                System.out.print(game.getGameBoard().getGrid()[i][j] + " ");
            }
            System.out.println();
        }


        startGame();
    }

    private static void startGame() {

        ViewName view = ViewName.WEB;

        while(true) {

            if(!game.getGameStatus().equals(GameStatus.PLAYING))
                break;

            if(view.equals(ViewName.TERMINAL))
                terminalView.terminalInput();


            if(view.equals(ViewName.TERMINAL)) {
                terminalView.playerMessage = game.playMove(terminalView.direction);
                terminalView.terminalOutput();
            }
            else {
                webView.playerMessage = game.playMove(webView.direction);
            }
            System.out.println(webView.direction + " " + webView.playerMessage);
        }

        if(game.getGameStatus().equals(GameStatus.WIN))
            System.out.println("You Win");
        else
            System.out.println("You Lost");
    }
}

enum ViewName {
    WEB,
    TERMINAL;
}