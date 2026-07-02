package com.satya.movie_booking.controller;

import com.satya.movie_booking.entity.Cinema;
import com.satya.movie_booking.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    // GET /api/cinemas
    @GetMapping
    public List<Cinema> getAllCinemas() {
        return cinemaService.getAllCinemas();
    }

    // GET /api/cinemas/city/1
    @GetMapping("/city/{cityId}")
    public List<Cinema> getCinemasByCity(@PathVariable Long cityId) {
        return cinemaService.getCinemasByCity(cityId);
    }

    // GET /api/cinemas/1
    @GetMapping("/{id}")
    public Cinema getCinema(@PathVariable Long id) {
        return cinemaService.getCinemaById(id);
    }

    // POST /api/cinemas/city/1
    @PostMapping("/city/{cityId}")
    public Cinema addCinema(@PathVariable Long cityId,
                            @RequestBody Cinema cinema) {
        return cinemaService.addCinema(cityId, cinema);
    }

    // DELETE /api/cinemas/1
    @DeleteMapping("/{id}")
    public String deleteCinema(@PathVariable Long id) {
        cinemaService.deleteCinema(id);
        return "Cinema deleted!";
    }
}