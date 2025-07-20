package com.cognizant.greet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    private static final Logger logger = LoggerFactory.getLogger(GreetController.class);

    @GetMapping("/greet")
    public String getGreet(){
        logger.info("Sending greetings..");
        return "Hello World";
    }
}
