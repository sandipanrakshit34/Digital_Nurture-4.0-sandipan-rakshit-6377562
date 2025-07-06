package com.example.countryservice.service;

import com.example.countryservice.entity.Country;
import com.example.countryservice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Optional<Country> getCountryByCode(String code) {
        return countryRepository.findById(code);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    public List<Country> searchCountriesByName(String name) {
        return countryRepository.findByCoNameContainingIgnoreCase(name);
    }
}
