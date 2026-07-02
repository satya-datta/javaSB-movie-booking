package com.satya.movie_booking.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String poster;      // poster image URL
    private String banner;      // banner image URL

    // ---- genre: ["Action", "Thriller"] → stored as separate table
    @ElementCollection
    @CollectionTable(name = "movie_genres",
        joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    private List<String> genre;

    // ---- language: ["English", "Hindi"] → stored as separate table
    @ElementCollection
    @CollectionTable(name = "movie_languages",
        joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "language")
    private List<String> language;

    private double rating;
    private String votes;
    private String duration;

    @Column(columnDefinition = "TEXT")
    private String description;

    // ---- cast: [{name, role, avatar}] → stored as separate table
    @ElementCollection
    @CollectionTable(name = "movie_cast",
        joinColumns = @JoinColumn(name = "movie_id"))
    private List<CastMember> cast;

    private String director;
    private String releaseDate;
    private String certificate;   // U, UA, A etc

    // ----  Constructors ----
    public Movie() {}

    // ---- Getters and Setters ----
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }

    public String getBanner() { return banner; }
    public void setBanner(String banner) { this.banner = banner; }

    public List<String> getGenre() { return genre; }
    public void setGenre(List<String> genre) { this.genre = genre; }

    public List<String> getLanguage() { return language; }
    public void setLanguage(List<String> language) { this.language = language; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getVotes() { return votes; }
    public void setVotes(String votes) { this.votes = votes; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<CastMember> getCast() { return cast; }
    public void setCast(List<CastMember> cast) { this.cast = cast; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public String getCertificate() { return certificate; }
    public void setCertificate(String certificate) { this.certificate = certificate; }
}