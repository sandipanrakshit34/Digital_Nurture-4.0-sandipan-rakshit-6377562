package com.example.countryservice;

import com.example.countryservice.entity.Country;
import com.example.countryservice.exception.CountryNotFoundException;
import com.example.countryservice.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryServiceApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceApplication.class);

	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(CountryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		getCountryByCodeTest();
	}

	private void getCountryByCodeTest() {
		LOGGER.info("Start");
		try {
			Country country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country: {}", country);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Exception: {}", e.getMessage());
		}
		LOGGER.info("End");
	}
}
