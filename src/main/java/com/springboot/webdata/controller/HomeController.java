package com.springboot.webdata.controller;

import com.springboot.webdata.WebCrawler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Arrays;

@Controller
public class HomeController {

    @RequestMapping({"/", "home"})
    public String home(ModelMap model, Principal user){
        //System.out.println("hi");
        String userName = user.getName();
        model.addAttribute("myHeading", userName + "'s Page");
        model.addAttribute("people", Arrays.asList(
                new Person("Vivek",17),
                new Person("John",20),
                new Person("Sarah",22)
        ));

        return "home";
    }
    @RequestMapping("about")
    public String about() {
        System.out.println("about");
        return "about.html";
    }

}
