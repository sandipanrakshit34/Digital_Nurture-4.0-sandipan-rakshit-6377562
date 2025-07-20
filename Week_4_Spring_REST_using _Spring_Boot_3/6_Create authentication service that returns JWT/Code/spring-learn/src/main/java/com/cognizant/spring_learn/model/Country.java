package com.cognizant.spring_learn.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private String code;
    private String name;

    private static final Logger logger = LoggerFactory.getLogger(Country.class);

    public Country(){
        logger.debug("Inside Country Constructor.");
    }

    public String getCode() {
        logger.debug("Inside getCode");
        return code;
    }

    public void setCode(String code) {
        logger.debug("Inside setCode");
        this.code = code;
    }

    public String getName() {
        logger.debug("Inside getName");
        return name;
    }

    public void setName(String name) {
        logger.debug("Inside setName");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
