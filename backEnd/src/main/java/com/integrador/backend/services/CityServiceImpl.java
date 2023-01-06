package com.integrador.backend.services;

import com.integrador.backend.model.City;
import com.integrador.backend.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;
    final static Logger logger = Logger.getLogger(CityServiceImpl.class.getName());

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> searchAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> searchCityById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City updateCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
