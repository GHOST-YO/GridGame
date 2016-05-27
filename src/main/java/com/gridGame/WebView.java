package com.gridGame;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by prashant.gu on 5/26/2016.
 *
 */

@RestController
public class WebView extends WebMvcConfigurerAdapter {

    Direction direction;
    String playerMessage;

    WebView() {
        this.direction = Direction.NONE;
        this.playerMessage = "EMPTY MESSAGE";
    }

    @RequestMapping(value="/")
    public String showForm() {
        return "/input";
    }

    @RequestMapping(value="/UP")
    public String UpMove() {
        this.direction = Direction.UP;
        return this.playerMessage;
    }

    @RequestMapping(value="/RIGHT")
    public String RIGHTMove() {
        this.direction = Direction.RIGHT;
        return this.playerMessage;
    }

    @RequestMapping(value="/LEFT")
    public String LeftMove() {
        this.direction = Direction.LEFT;
        return this.playerMessage;
    }

    @RequestMapping(value="/DOWN")
    public String DownMove() {
        this.direction = Direction.DOWN;
        return this.playerMessage;
    }
}
