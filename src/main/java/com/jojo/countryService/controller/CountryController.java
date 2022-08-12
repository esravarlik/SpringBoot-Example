package com.jojo.countryService.controller;

import com.jojo.countryService.model.Country;
import com.jojo.countryService.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getCountries(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(countryService.getCountry(name), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable String id) {
        return new ResponseEntity<>(getCountryById(id), OK);
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country newCountry) {

        return new ResponseEntity<>(countryService.createCountry(newCountry), HttpStatus.CREATED); // CREATED = 201
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> getCountry(@PathVariable String id, @RequestBody Country newCountry) {

        countryService.updateCountry(id, newCountry);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String id){
        countryService.deleteCountry(id);
        return new ResponseEntity<>(OK);
    }

    private Country getCountryById(String id){
        return countryService.getCountryById(id);
    }

}

