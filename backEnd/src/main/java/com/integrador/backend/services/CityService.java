package com.integrador.backend.services;

import com.integrador.backend.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    City saveCity(City city);
    List<City> searchAllCities();
    Optional<City> searchCityById(Long id);
    City updateCity(City city);
    void deleteCity(Long id);
}
