/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Bron Zilar
 */
public class MovieDto implements Serializable {
    private static final long serialVersionUID = 2151959395889955260L;
    private Long id;
    private String title;
    private int duration;
    private Genre genre;
    private int year;
    private String language;
    private double ratingIMDb;

    public MovieDto() {
    }

    public MovieDto(String title, int duration, Genre genre, int year, String language, double ratingIMDb) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.year = year;
        this.language = language;
        this.ratingIMDb = ratingIMDb;
    }  
    
    public MovieDto(Long id, String title, int duration, Genre genre, int year, String language, double ratingIMDb) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.year = year;
        this.language = language;
        this.ratingIMDb = ratingIMDb;
    }

    public double getRatingIMDb() {
        return ratingIMDb;
    }

    public void setRatingIMDb(double ratingIMDb) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.title);
        hash = 11 * hash + this.duration;
        hash = 11 * hash + Objects.hashCode(this.genre);
        hash = 11 * hash + this.year;
        hash = 11 * hash + Objects.hashCode(this.language);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.ratingIMDb) ^ (Double.doubleToLongBits(this.ratingIMDb) >>> 32));
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
        final MovieDto other = (MovieDto) obj;
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

    @Override
    public String toString() {
        return "MovieDto{" + "id=" + id + ", title=" + title + ", duration=" + duration + ", genre=" + genre + ", yearr=" + year + ", languagee=" + language + ", ratingIMDb=" + ratingIMDb + '}';
    }

    
    

    
}
