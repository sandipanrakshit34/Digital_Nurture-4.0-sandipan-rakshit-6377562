package com.cognizant.loan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

    @GetMapping("/loans/{number}")
    public String getLoanDetails(@PathVariable("number") String number){
        logger.info("Start");
        String type = "car";
        long loan = 400000;
        long emi = 3258;
        int tenure = 18;
        String result = "Number: "+number+" ,type: "+type+" ,emi: "+emi+" ,tenure: "+tenure;
        logger.debug("Sending loan details for account number: {}",number);
        logger.info("End");
        return result;
    }
}
