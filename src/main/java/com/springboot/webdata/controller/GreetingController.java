package com.springboot.webdata.controller;

import com.springboot.webdata.Customer;
import com.springboot.webdata.WebCrawler;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingController {

    @GetMapping(value = "/customer",produces = "application/json")
    public String customer() {
        return WebCrawler.jsonMapper();
    }
    @GetMapping(value = "/customer1",produces = "application/json")
    public List<Customer> customer1() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId((long) 1);
        customer.setAge(17);
        customer.setName("Vivek");
        Customer customer2 = new Customer();
        customer2.setId((long) 1);
        customer2.setAge(17);
        customer2.setName("Vivek");
        customers.add(customer);
        customers.add(customer2);
        return customers;
    }
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
