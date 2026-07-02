package com.satya.movie_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satya.movie_booking.entity.Screen;

import java.util.List;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
    // Get all screens in a cinema
    List<Screen> findByCinemaId(Long cinemaId);
}