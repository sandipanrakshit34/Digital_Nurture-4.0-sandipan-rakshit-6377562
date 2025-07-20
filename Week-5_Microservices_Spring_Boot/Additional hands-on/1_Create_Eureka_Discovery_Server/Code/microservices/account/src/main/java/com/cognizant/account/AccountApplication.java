package com.cognizant.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountApplication {
	private static final Logger logger = LoggerFactory.getLogger(AccountApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(AccountApplication.class, args);
		logger.info("SpringBoot Application started successfully");
	}

}
