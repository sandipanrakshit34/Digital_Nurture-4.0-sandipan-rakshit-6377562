package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		System.out.println("Application Starting...");
		SpringApplication.run(SpringLearnApplication.class, args);
		System.out.println("Application Started Successfully.");

		displayDate(); // Call the method here
	}

	public static void displayDate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			System.out.println("Parsed Date: " + date);
		} catch (Exception e) {
			System.out.println("Date parsing failed: " + e.getMessage());
		}
	}
}
