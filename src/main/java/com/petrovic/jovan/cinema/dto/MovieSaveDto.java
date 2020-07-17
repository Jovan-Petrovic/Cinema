/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author fonis
 */
public class MovieSaveDto {

    private static final long serialVersionUID = 2151959395889955289L;
    private Long id;
    private String title;
    private int duration;
    private Genre genre;
    private int year;
    private String language;
    private double ratingIMDb;

    private List<Long> directorIds;
    private List<Long> actorIds;

    public MovieSaveDto(Long id, String title, int duration, Genre genre, int year, String language, double ratingIMDb) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.year = year;
        this.language = language;
        this.ratingIMDb = ratingIMDb;
        this.directorIds = new ArrayList<>();
        this.actorIds = new ArrayList<>();
    }

    public MovieSaveDto(String title, int duration, Genre genre, int year, String language, double ratingIMDb) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.year = year;
        this.language = language;
        this.ratingIMDb = ratingIMDb;
        this.directorIds = new ArrayList<>();
        this.actorIds = new ArrayList<>();
    }

    public MovieSaveDto() {
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

    public List<Long> getDirectorIds() {
        return directorIds;
    }

    public void setDirectorIds(List<Long> directorIds) {
        this.directorIds = directorIds;
    }

    public List<Long> getActorIds() {
        return actorIds;
    }

    public void setActorIds(List<Long> actorIds) {
        this.actorIds = actorIds;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.title);
        hash = 83 * hash + Objects.hashCode(this.directorIds);
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
        final MovieSaveDto other = (MovieSaveDto) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.directorIds, other.directorIds)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MovieSaveDto{id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", duration=").append(duration);
        sb.append(", genre=").append(genre);
        sb.append(", year=").append(year);
        sb.append(", language=").append(language);
        sb.append(", ratingIMDb=").append(ratingIMDb);
        sb.append(", directorDtos=").append(directorIds);
        sb.append(", actorDtos=").append(actorIds);
        sb.append('}');
        return sb.toString();
    }
    
    

}
