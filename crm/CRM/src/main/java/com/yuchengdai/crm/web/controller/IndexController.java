package com.yuchengdai.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * RoyDai
 * 2020/3/5   19:34
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String toIndex(){
        return "index";
    }
}
