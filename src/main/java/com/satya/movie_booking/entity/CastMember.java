package com.satya.movie_booking.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class CastMember {

    private String name;
    private String role;
    private String avatar;    // avatar image URL

    // ---- Constructors ----
    public CastMember() {}

    // ---- Getters and Setters ----
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
}