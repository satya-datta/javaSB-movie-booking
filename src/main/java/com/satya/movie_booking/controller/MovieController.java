package com.satya.movie_booking.controller;
import com.satya.movie_booking.entity.Movie;
import com.satya.movie_booking.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")   // allows React frontend to call this API
public class MovieController {

    @Autowired
    private MovieService movieService;

    // GET /api/movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // GET /api/movies/1
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    // POST /api/movies
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie saved = movieService.createMovie(movie);
        return ResponseEntity.ok(saved);
    }

    // PUT /api/movies/1
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id,
                                             @RequestBody Movie movie) {
        Movie updated = movieService.updateMovie(id, movie);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/movies/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }

    // GET /api/movies/search?title=inception
    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam String title) {
        return movieService.searchByTitle(title);
    }

    // GET /api/movies/genre?name=Action
    @GetMapping("/genre")
    public List<Movie> getByGenre(@RequestParam String name) {
        return movieService.getByGenre(name);
    }

    // GET /api/movies/language?name=Hindi
    @GetMapping("/language")
    public List<Movie> getByLanguage(@RequestParam String name) {
        return movieService.getByLanguage(name);
    }
}
