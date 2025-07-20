package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/country/{code}")
    public Country getCountryByCode(@PathVariable("code") String code){
        logger.info("Start");
        Country country = countryService.getCountry(code);
        logger.debug("Sending message: {}", country.toString());
        logger.info("End");
        return country;
    }

    @GetMapping("/countries")
    public List<Country> getCountryIndia(){
        logger.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> list = context.getBean("countryList",List.class);
        logger.debug("Sending message: {}", list);
        logger.info("End");
        return list;
    }

}
