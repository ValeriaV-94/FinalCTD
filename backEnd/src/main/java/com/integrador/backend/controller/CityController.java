package com.integrador.backend.controller;

import com.integrador.backend.exceptions.BadRequestException;
import com.integrador.backend.exceptions.ResourcesNotFoundException;
import com.integrador.backend.model.City;
import com.integrador.backend.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    //Crear ciudad

    @PostMapping("/save")
    public ResponseEntity<City> saveCity(@RequestBody City city) throws BadRequestException{
        try{
            City savedCity = cityService.saveCity(city);
            return ResponseEntity.ok(savedCity);
        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }
    }

    //Buscar todas las ciudades.
    @GetMapping("all")
    public ResponseEntity<List<City>> searchAllCity(){
        return ResponseEntity.ok(cityService.searchAllCities());
    }

    //Buscar ciudad por id.
    @GetMapping("/search/{id}")
    public ResponseEntity<City> searchCityById(@PathVariable("id") Long id) throws ResourcesNotFoundException{
        Optional<City> searchCity = cityService.searchCityById(id);
        if (searchCity.isPresent()){
            return ResponseEntity.ok(searchCity.get());
        }else {
            throw new ResourcesNotFoundException("No se encontrò la categorìa con id = " + id);
        }
    }

    //Actualizar ciudad
    @PutMapping("/update")
    public ResponseEntity<City> updateCity(@RequestBody City city){
        Optional<City> cityToUpdate = cityService.searchCityById(city.getId());
        if (cityToUpdate.isPresent()){
            return ResponseEntity.ok(cityService.updateCity(city));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Borrar ciudad.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCityById(@PathVariable Long id) throws ResourcesNotFoundException{
        Optional<City> cityToDelete = cityService.searchCityById(id);
        if(cityToDelete.isPresent()){
            cityService.deleteCity(id);
            return ResponseEntity.ok("Se eliminó la ciudad con id = " + id);
        } else {
            throw new ResourcesNotFoundException("No se encontró la categoría con id = " + id);
        }
    }








}
