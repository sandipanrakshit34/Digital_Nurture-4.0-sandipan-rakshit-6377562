package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/hello")
    public String sayHello(){
        logger.info("Start");
        String msg = "Hello World!!";
        logger.debug("Sending message:{}",msg);
        logger.info("End");
        return msg;
    }
}
