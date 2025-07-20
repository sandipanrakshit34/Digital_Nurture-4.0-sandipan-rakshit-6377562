package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	private final static Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {

		 ApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);
//		LOGGER.debug("ApplicationContext initialized with {} beans", context.getBeanDefinitionCount());
		LOGGER.info("SpringLearnApplication started successfully!");
		displayDate();
	}

	private static void displayDate(){
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try{
			String givenDate = "31/12/2018";
			Date date = format.parse(givenDate);
			LOGGER.debug("Displaying date for {" + givenDate + "}: " + date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		LOGGER.info("End");
	}

	private static void testApplication(){
		LOGGER.info("Start testMethod");
		LOGGER.debug("App started at: {}", java.time.LocalDateTime.now());
		LOGGER.info("End testMethod");
	}
}
