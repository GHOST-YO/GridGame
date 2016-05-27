package com.gridGame;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by prashant.gu on 5/26/2016.
 *
 */

@Controller
@EnableAutoConfiguration
@ResponseBody
public class WebView extends WebMvcConfigurerAdapter {

    private Direction direction;
    private String playerMessage;
    private boolean isMoveComplete;

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

    public boolean getIsMoveComplete() {
        return isMoveComplete;
    }

    public void setIsMoveComplete(boolean isMoveComplete) {
        this.isMoveComplete = isMoveComplete;
    }

    WebView() {
        this.direction = Direction.NONE;
        this.playerMessage = "EMPTY MESSAGE";


        this.isMoveComplete = false;
    }

    @RequestMapping(value="/")
    public String showForm() {
        return "/input";
    }

    @RequestMapping(value="/UP")
    public String UpMove() {
        this.direction = Direction.UP;
        while(!this.isMoveComplete) {}
        return this.playerMessage;
    }

    @RequestMapping(value="/RIGHT")
    public String RIGHTMove() {
        this.direction = Direction.RIGHT;
        while(!this.isMoveComplete) {}
        return this.playerMessage;
    }

    @RequestMapping(value="/LEFT")
    public String LeftMove() {
        this.direction = Direction.LEFT;
        while(!this.isMoveComplete) {}
        return this.playerMessage;
    }

    @RequestMapping(value="/DOWN")
    public String DownMove() {
        this.direction = Direction.DOWN;
        while(!this.isMoveComplete) {}
        return this.playerMessage;
    }
}
