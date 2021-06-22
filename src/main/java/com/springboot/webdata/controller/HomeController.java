package com.springboot.webdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("home")
    public String home(){
        System.out.println("hi");
        return "home.html";
    }
    @RequestMapping("about")
    public String about() {
        System.out.println("about");
        return "about.html";
    }
}
