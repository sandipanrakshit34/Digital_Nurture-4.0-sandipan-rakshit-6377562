package com.example.countryservice;

import com.example.countryservice.entity.Country;
import com.example.countryservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		LOGGER.info("Start");

		testAddCountry();

		LOGGER.info("End");
	}

	private void testAddCountry() {
		Country country = new Country("JP", "Japan");
		countryService.addCountry(country);

		Country result = countryService.findCountryByCode("JP");
		LOGGER.debug("Country: {}", result);
	}
}
