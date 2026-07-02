package com.satya.movie_booking.controller;

import com.satya.movie_booking.entity.City;
import com.satya.movie_booking.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    // GET /api/cities
    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    // GET /api/cities/1
    @GetMapping("/{id}")
    public City getCity(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    // POST /api/cities
    @PostMapping
    public City addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    // DELETE /api/cities/1
    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return "City deleted!";
    }
}