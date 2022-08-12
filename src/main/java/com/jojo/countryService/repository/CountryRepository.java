package com.jojo.countryService.repository;

import com.jojo.countryService.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends MongoRepository<Country, String> {

    List<Country> findByName(String name);
}
