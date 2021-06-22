package com.springboot.webdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {
    //@RequestMapping("home")
    public String home(ModelMap model, Principal user){
        //System.out.println("hi");
        String userName = user.getName();
        model.addAttribute("myHeading", userName + "'s Page");
        return "home";
    }
    @RequestMapping("about")
    public String about() {
        System.out.println("about");
        return "about.html";
    }

}
