package com.gridGame;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by prashant.gu on 5/26/2016.
 *
 */

@Controller
public class WebView extends WebMvcConfigurerAdapter {

    @RequestMapping(value="/")
    public String showForm() {
        return "/input";
    }

    @RequestMapping(value="/UP")
    public String UpMove() {
        return "DOWN";
    }

    @RequestMapping(value="/RIGHT")
    public String DownMove() {
        return "RIGHT";
    }

    @RequestMapping(value="/LEFT")
    public String LeftMove() {
        return "LEFT";
    }

    @RequestMapping(value="/DOWN")
    public String RightMove() {
        return "DOWN";
    }
}
