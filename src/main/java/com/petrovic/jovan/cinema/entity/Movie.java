/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.entity;

import com.petrovic.jovan.cinema.dto.Genre;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Bron Zilar
 */
@Entity
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private int duration;
    private Genre genre;
    private int year;
    private String language;
    private double ratingIMDb;

    public Movie() {
    }

    public Movie(Long id, String title, int duration, Genre genre, int year, String language, double ratingIMDb) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.year = year;
        this.language = language;
        this.ratingIMDb = ratingIMDb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getRatingIMDb() {
        return ratingIMDb;
    }

    public void setRatingIMDb(double ratingIMDb) {
        this.ratingIMDb = ratingIMDb;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.title);
        hash = 61 * hash + this.duration;
        hash = 61 * hash + Objects.hashCode(this.genre);
        hash = 61 * hash + this.year;
        hash = 61 * hash + Objects.hashCode(this.language);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.ratingIMDb) ^ (Double.doubleToLongBits(this.ratingIMDb) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (this.duration != other.duration) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (Double.doubleToLongBits(this.ratingIMDb) != Double.doubleToLongBits(other.ratingIMDb)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.genre != other.genre) {
            return false;
        }
        return true;
    }
    
    
}
