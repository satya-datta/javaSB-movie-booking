package com.satya.movie_booking.service;

import com.satya.movie_booking.dto.ShowtimeResponseDTO;
import com.satya.movie_booking.entity.Movie;
import com.satya.movie_booking.entity.Screen;
import com.satya.movie_booking.entity.Showtime;
import com.satya.movie_booking.repository.MovieRepository;
import com.satya.movie_booking.repository.ScreenRepository;
import com.satya.movie_booking.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreenRepository screenRepository;

    // Add a showtime
    public Showtime addShowtime(Long movieId, Long screenId, Showtime showtime) {
        Movie movie = movieRepository.findById(movieId)
            .orElseThrow(() -> new RuntimeException("Movie not found: " + movieId));
        Screen screen = screenRepository.findById(screenId)
            .orElseThrow(() -> new RuntimeException("Screen not found: " + screenId));

        showtime.setMovie(movie);
        showtime.setScreen(screen);
        return showtimeRepository.save(showtime);
    }

    // Get showtimes grouped by cinema
    // This is what your frontend needs!
    public List<ShowtimeResponseDTO> getShowtimesByMovieDateCity(
            Long movieId, LocalDate date, Long cityId) {

        List<Showtime> showtimes = showtimeRepository
            .findByMovieDateCity(movieId, date, cityId);

        // Group by cinema
        Map<Long, ShowtimeResponseDTO> cinemaMap = new LinkedHashMap<>();

        for (Showtime s : showtimes) {
            Long cinemaId = s.getScreen().getCinema().getId();

            // If cinema not in map yet, add it
            if (!cinemaMap.containsKey(cinemaId)) {
                cinemaMap.put(cinemaId, new ShowtimeResponseDTO(
                    cinemaId,
                    s.getScreen().getCinema().getName(),
                    s.getScreen().getCinema().getArea(),
                    new ArrayList<>()
                ));
            }

            // Add this show to the cinema
            cinemaMap.get(cinemaId).getShows().add(
                new ShowtimeResponseDTO.ShowDTO(
                    s.getId(),
                    s.getStartTime().toString(),
                    s.getFormat(),
                    s.getLanguage(),
                    s.getBasePrice()
                )
            );
        }

        return new ArrayList<>(cinemaMap.values());
    }

    public Showtime getShowtimeById(Long id) {
        return showtimeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Showtime not found: " + id));
    }

    public void deleteShowtime(Long id) {
        showtimeRepository.deleteById(id);
    }
}