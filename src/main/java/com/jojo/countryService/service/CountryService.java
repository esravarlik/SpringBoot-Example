package com.jojo.countryService.service;

import com.jojo.countryService.model.Country;
import com.jojo.countryService.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }
    public List<Country> getCountry(String name){
        if(name == null){
            return countryRepository.findAll();
        }else{
            return countryRepository.findByName(name);
        }

    }

    public Country createCountry(Country newCountry) {
        return countryRepository.save(newCountry);
    }

    public void deleteCountry(String id) {
        countryRepository.deleteById(id);
    }

    public Country getCountryById(String id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Count not found"));
    }

    public void updateCountry(String id, Country newCountry) {
        Country oldCountry = getCountryById(id);
        oldCountry.setName(newCountry.getName());
        countryRepository.save(oldCountry);
    }
}
