package com.example.countryservice.controller;

import com.example.countryservice.entity.Country;
import com.example.countryservice.exception.CountryNotFoundException;
import com.example.countryservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
        return countryService.findCountryByCode(code);
    }
}
