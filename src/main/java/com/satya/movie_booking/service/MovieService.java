package com.satya.movie_booking.service;

import com.satya.movie_booking.entity.Movie;
import com.satya.movie_booking.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Get movie by ID
    public Movie getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return movie.get();
        }
        throw new RuntimeException("Movie not found with id: " + id);
    }

    // Create a new movie
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Update a movie
    public Movie updateMovie(Long id, Movie updatedMovie) {
        Movie existing = getMovieById(id);  // throws if not found

        existing.setTitle(updatedMovie.getTitle());
        existing.setPoster(updatedMovie.getPoster());
        existing.setBanner(updatedMovie.getBanner());
        existing.setGenre(updatedMovie.getGenre());
        existing.setLanguage(updatedMovie.getLanguage());
        existing.setRating(updatedMovie.getRating());
        existing.setVotes(updatedMovie.getVotes());
        existing.setDuration(updatedMovie.getDuration());
        existing.setDescription(updatedMovie.getDescription());
        existing.setCast(updatedMovie.getCast());
        existing.setDirector(updatedMovie.getDirector());
        existing.setReleaseDate(updatedMovie.getReleaseDate());
        existing.setCertificate(updatedMovie.getCertificate());

        return movieRepository.save(existing);
    }

    // Delete a movie
    public void deleteMovie(Long id) {
        getMovieById(id);  // throws if not found
        movieRepository.deleteById(id);
    }

    // Search by title
    public List<Movie> searchByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    // Filter by genre
    public List<Movie> getByGenre(String genre) {
        return movieRepository.findByGenreContaining(genre);
    }

    // Filter by language
    public List<Movie> getByLanguage(String language) {
        return movieRepository.findByLanguageContaining(language);
    }
}