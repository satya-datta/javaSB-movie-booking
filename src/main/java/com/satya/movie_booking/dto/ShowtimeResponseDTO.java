package com.satya.movie_booking.dto;

import java.util.List;

public class ShowtimeResponseDTO {

    private Long cinemaId;
    private String cinemaName;
    private String cinemaArea;
    private List<ShowDTO> shows;

    public ShowtimeResponseDTO() {}

    public ShowtimeResponseDTO(Long cinemaId, String cinemaName,
                                String cinemaArea, List<ShowDTO> shows) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.cinemaArea = cinemaArea;
        this.shows = shows;
    }

    // Getters and Setters
    public Long getCinemaId() { return cinemaId; }
    public void setCinemaId(Long cinemaId) { this.cinemaId = cinemaId; }

    public String getCinemaName() { return cinemaName; }
    public void setCinemaName(String cinemaName) { this.cinemaName = cinemaName; }

    public String getCinemaArea() { return cinemaArea; }
    public void setCinemaArea(String cinemaArea) { this.cinemaArea = cinemaArea; }

    public List<ShowDTO> getShows() { return shows; }
    public void setShows(List<ShowDTO> shows) { this.shows = shows; }


    // ---- Inner class for each show ----
    public static class ShowDTO {
        private Long showtimeId;
        private String startTime;
        private String format;
        private String language;
        private double basePrice;

        public ShowDTO() {}

        public ShowDTO(Long showtimeId, String startTime,
                       String format, String language, double basePrice) {
            this.showtimeId = showtimeId;
            this.startTime = startTime;
            this.format = format;
            this.language = language;
            this.basePrice = basePrice;
        }

        public Long getShowtimeId() { return showtimeId; }
        public void setShowtimeId(Long showtimeId) { this.showtimeId = showtimeId; }

        public String getStartTime() { return startTime; }
        public void setStartTime(String startTime) { this.startTime = startTime; }

        public String getFormat() { return format; }
        public void setFormat(String format) { this.format = format; }

        public String getLanguage() { return language; }
        public void setLanguage(String language) { this.language = language; }

        public double getBasePrice() { return basePrice; }
        public void setBasePrice(double basePrice) { this.basePrice = basePrice; }
    }
}
