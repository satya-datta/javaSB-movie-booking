package com.satya.movie_booking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satya.movie_booking.entity.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // find by title containing (search)
    List<Movie> findByTitleContainingIgnoreCase(String title);

    // find by genre
    List<Movie> findByGenreContaining(String genre);

    // find by language
    List<Movie> findByLanguageContaining(String language);
}