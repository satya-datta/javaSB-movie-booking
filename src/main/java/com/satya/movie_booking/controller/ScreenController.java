package com.satya.movie_booking.controller;

import com.satya.movie_booking.entity.Screen;
import com.satya.movie_booking.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/screens")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    // GET /api/screens/cinema/1
    @GetMapping("/cinema/{cinemaId}")
    public List<Screen> getScreensByCinema(@PathVariable Long cinemaId) {
        return screenService.getScreensByCinema(cinemaId);
    }

    // GET /api/screens/1
    @GetMapping("/{id}")
    public Screen getScreen(@PathVariable Long id) {
        return screenService.getScreenById(id);
    }

    // POST /api/screens/cinema/1
    @PostMapping("/cinema/{cinemaId}")
    public Screen addScreen(@PathVariable Long cinemaId,
                            @RequestBody Screen screen) {
        return screenService.addScreen(cinemaId, screen);
    }

    // DELETE /api/screens/1
    @DeleteMapping("/{id}")
    public String deleteScreen(@PathVariable Long id) {
        screenService.deleteScreen(id);
        return "Screen deleted!";
    }
}