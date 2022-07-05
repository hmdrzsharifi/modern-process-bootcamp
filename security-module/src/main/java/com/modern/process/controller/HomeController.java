package com.modern.process.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/")
    public String getHomePage(){
        return "Hello World";
    }

    @GetMapping("/home")
    public String getHome(){
        return "Hello World";
    }
}
