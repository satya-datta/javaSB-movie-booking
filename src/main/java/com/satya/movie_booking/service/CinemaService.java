package com.satya.movie_booking.service;

import com.satya.movie_booking.entity.Cinema;
import com.satya.movie_booking.entity.City;
import com.satya.movie_booking.repository.CinemaRepository;
import com.satya.movie_booking.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    public List<Cinema> getCinemasByCity(Long cityId) {
        return cinemaRepository.findByCityId(cityId);
    }

    public Cinema getCinemaById(Long id) {
        return cinemaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cinema not found: " + id));
    }

    public Cinema addCinema(Long cityId, Cinema cinema) {
        City city = cityRepository.findById(cityId)
            .orElseThrow(() -> new RuntimeException("City not found: " + cityId));
        cinema.setCity(city);
        return cinemaRepository.save(cinema);
    }

    public void deleteCinema(Long id) {
        cinemaRepository.deleteById(id);
    }
}