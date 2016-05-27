package com.gridGame;

/**
 * Created by prashant.gu on 5/25/2016.
 *
 */


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import java.util.*;

@SpringBootApplication
public class Application {
    private static Scanner scanner = new Scanner(System.in);
    private static WebView webView = null;
    private static TerminalView terminalView = null;

    public static void main(String[] args) {

        ViewName view = ViewName.TERMINAL;

        switch (view) {
            case TERMINAL:
                terminalView = new TerminalView();
                terminalView.startGame();
                break;
            case WEB:
                SpringApplication.run(Application.class, args);
                break;
        }
    }
}

enum ViewName {
    WEB,
    TERMINAL
}