package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.web.WebMvcProperties;

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


        ViewName view = ViewName.WEB;

        switch (view) {
            case TERMINAL:
                startGame(terminalView);
                break;
            case WEB:
                startGame(webView);
                break;
        }
    }

    private static void startGame(InputInterface inputModel) {

        while(true) {

            if(!game.getGameStatus().equals(GameStatus.PLAYING))
                break;

            inputModel.printPlayerMessage(game.playMove(inputModel.getDirection()));

        }

        if(game.getGameStatus().equals(GameStatus.WIN))
            System.out.println("You Win");
        else
            System.out.println("You Lost");
    }
}

enum ViewName {
    WEB,
    TERMINAL
}