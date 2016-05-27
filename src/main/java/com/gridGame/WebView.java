package com.gridGame;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jta.bitronix.PoolingConnectionFactoryBean;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by prashant.gu on 5/26/2016.
 *
 */

@Controller
@EnableAutoConfiguration
@ResponseBody
public class WebView extends WebMvcConfigurerAdapter implements InputInterface{

    private boolean waitBool;
    private Direction direction = Direction.NONE;
    private String playerMessage = "EMPTY MESSAGE";
    private String playerName = "";



    @Override
    public String getPlayerName() {
        System.out.println("waiting For Player Name");
        this.waitBool = true;

        while(waitBool) {}

        return playerName;
    }

    @Override
    public Direction getDirection() {
        System.out.println("Waiting to get Directions");

        this.waitBool = true;
        while(this.waitBool) {}

        return null;
    }

    @Override
    @RequestMapping(value="/result")
    public String printPlayerMessage(String playerMessage) {
        return playerMessage;
    }

    @RequestMapping(value="/{id}/**")
    public String newName(@PathVariable("id") String id, HttpServletRequest request) {
        String path = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String bestMatchPattern = (String ) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);

        AntPathMatcher apm = new AntPathMatcher();
        String finalPath = apm.extractPathWithinPattern(bestMatchPattern, path);

        playerName = finalPath;

        return finalPath;
    }

    @RequestMapping(value="/{direction}")
    public String move(@PathVariable String direction, HttpServletRequest request) {

        direction = direction.toUpperCase();

        switch(direction) {
            case "UP":
                this.direction = Direction.UP;
                break;
            case "DOWN":
                this.direction = Direction.DOWN;
                break;
            case "LEFT":
                this.direction = Direction.LEFT;
                break;
            case "RIGHT":
                this.direction = Direction.RIGHT;
                break;
        }

        this.direction = Direction.UP;
        this.waitBool = false;
        return "Moving " + direction;
    }
}
