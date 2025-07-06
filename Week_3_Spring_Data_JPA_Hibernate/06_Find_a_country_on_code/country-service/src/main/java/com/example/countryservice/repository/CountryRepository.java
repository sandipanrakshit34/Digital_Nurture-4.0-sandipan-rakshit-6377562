package com.example.countryservice.repository;

import com.example.countryservice.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    // Match on Java property "name" (not "co_name")
    List<Country> findByNameContainingIgnoreCase(String name);

    // You can also find by code
    Country findByCode(String code);
}
