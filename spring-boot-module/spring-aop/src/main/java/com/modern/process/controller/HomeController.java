package com.modern.process.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String getHomePage(){
        logger.info("Method start: HomeController getHomePage");

        return "Hello World";
    }

    @GetMapping("/home")
    public String getHome(){
        logger.info("Method start: HomeController getHome");

        return "Hello World";
    }
}
