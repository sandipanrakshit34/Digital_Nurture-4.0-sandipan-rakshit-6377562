package com.cognizant.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/accounts/{number}")
    public String getAccountByNumber(@PathVariable("number") String number){
        logger.info("Start");
        String type = "Savings";
        long balance = 234343;
        logger.debug("Sending details for number: {}",number);
        String result = ("Number: "+number+" ,type: "+type+" ,balance: "+balance);
        logger.info("End");
        return result;
    }
}
