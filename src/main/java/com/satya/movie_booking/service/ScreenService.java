package com.satya.movie_booking.service;

import com.satya.movie_booking.entity.Cinema;
import com.satya.movie_booking.entity.Screen;
import com.satya.movie_booking.repository.CinemaRepository;
import com.satya.movie_booking.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScreenService {

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Screen> getScreensByCinema(Long cinemaId) {
        return screenRepository.findByCinemaId(cinemaId);
    }

    public Screen getScreenById(Long id) {
        return screenRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Screen not found: " + id));
    }

    public Screen addScreen(Long cinemaId, Screen screen) {
        Cinema cinema = cinemaRepository.findById(cinemaId)
            .orElseThrow(() -> new RuntimeException("Cinema not found: " + cinemaId));
        screen.setCinema(cinema);
        return screenRepository.save(screen);
    }

    public void deleteScreen(Long id) {
        screenRepository.deleteById(id);
    }
}