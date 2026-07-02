package com.satya.movie_booking.controller;

import com.satya.movie_booking.dto.ShowtimeResponseDTO;
import com.satya.movie_booking.entity.Showtime;
import com.satya.movie_booking.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    // POST /api/showtimes/movie/1/screen/1
    @PostMapping("/movie/{movieId}/screen/{screenId}")
    public Showtime addShowtime(
            @PathVariable Long movieId,
            @PathVariable Long screenId,
            @RequestBody Showtime showtime) {
        return showtimeService.addShowtime(movieId, screenId, showtime);
    }

    // GET /api/showtimes?movieId=1&date=2026-06-11&cityId=1
    // This is the main API your frontend calls!
    @GetMapping
    public List<ShowtimeResponseDTO> getShowtimes(
            @RequestParam Long movieId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam Long cityId) {
        return showtimeService.getShowtimesByMovieDateCity(movieId, date, cityId);
    }

    // GET /api/showtimes/1
    @GetMapping("/{id}")
    public Showtime getShowtime(@PathVariable Long id) {
        return showtimeService.getShowtimeById(id);
    }

    // DELETE /api/showtimes/1
    @DeleteMapping("/{id}")
    public String deleteShowtime(@PathVariable Long id) {
        showtimeService.deleteShowtime(id);
        return "Showtime deleted!";
    }
}