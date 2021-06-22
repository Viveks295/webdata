package com.springboot.webdata.controller;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class GreetingController {

    @RequestMapping(value = "/greeting")
    public String greet(@RequestParam(required = false, value = "name") String userName) {
        return "Hello there" + userName;
    }

    @GetMapping("user/{id}/name")
    public String name(@PathVariable(value = "id") int userId) {
        return Integer.toString(userId);
    }

    @GetMapping(value = "/hello")
    public String hello(Principal user) {
        return "Hello there " + user.getName();
    }
}
