package com.satya.movie_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satya.movie_booking.entity.Cinema;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    // Get all cinemas in a city
    List<Cinema> findByCityId(Long cityId);

    // Get all cinemas in a city by name
    List<Cinema> findByCityName(String cityName);
}