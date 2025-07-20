package com.cognizant.loan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanApplication {
	private static final Logger logger = LoggerFactory.getLogger(LoanApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(LoanApplication.class, args);
		logger.info("SpringBoot Application is running successfully...");
	}

}
