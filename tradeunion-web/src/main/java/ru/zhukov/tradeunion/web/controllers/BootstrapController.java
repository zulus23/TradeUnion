package ru.zhukov.tradeunion.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BootstrapController {
    @RequestMapping("/")
    public String indexPage(){
        return "index";
    }
}
