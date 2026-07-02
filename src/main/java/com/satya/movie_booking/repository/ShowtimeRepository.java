package com.satya.movie_booking.repository;

import com.satya.movie_booking.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    // Find showtimes by movie + date
    List<Showtime> findByMovieIdAndShowDate(Long movieId, LocalDate showDate);

    // Find showtimes by movie + date + city
    // We go: showtime → screen → cinema → city
    @Query("""
        SELECT s FROM Showtime s
        WHERE s.movie.id = :movieId
        AND s.showDate = :showDate
        AND s.screen.cinema.city.id = :cityId
        ORDER BY s.screen.cinema.name, s.startTime
    """)
    List<Showtime> findByMovieDateCity(
        @Param("movieId") Long movieId,
        @Param("showDate") LocalDate showDate,
        @Param("cityId") Long cityId
    );
}