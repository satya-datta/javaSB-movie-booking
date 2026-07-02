package com.satya.movie_booking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cinemas")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String area;

    // Many cinemas belong to one city
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    public Cinema() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }
}