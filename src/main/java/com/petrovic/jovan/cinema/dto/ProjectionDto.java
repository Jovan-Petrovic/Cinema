/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author Bron Zilar
 */
public class ProjectionDto implements Serializable {
    private static final long serialVersionUID = 2151959395889955260L;
    private Long id;
    private Timestamp dateTime;
    private String room;
    private int remainingSeats;
    private MovieDto movieDto;
    

    public ProjectionDto() {
        movieDto = new MovieDto();
    }

    public ProjectionDto(Long id, Timestamp dateTime, String room, int remainingSeats) {
        this.id = id;
        this.dateTime = dateTime;
        this.room = room;
        this.remainingSeats = remainingSeats;
    }
 
    public ProjectionDto(Long id, Timestamp dateTime, String room, int remainingSeats, MovieDto movieDto) {
        this.id = id;
        this.dateTime = dateTime;
        this.room = room;
        this.remainingSeats = remainingSeats;
        this.movieDto = movieDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public MovieDto getMovieDto() {
        return movieDto;
    }

    public void setMovieDto(MovieDto movieDto) {
        this.movieDto = movieDto;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.dateTime);
        hash = 71 * hash + Objects.hashCode(this.room);
        hash = 71 * hash + Objects.hashCode(this.movieDto);
        hash = 71 * hash + this.remainingSeats;
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
        final ProjectionDto other = (ProjectionDto) obj;
        if (this.remainingSeats != other.remainingSeats) {
            return false;
        }
        if (!Objects.equals(this.room, other.room)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateTime, other.dateTime)) {
            return false;
        }
        if (!Objects.equals(this.movieDto, other.movieDto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjectionDto{" + "id=" + id + ", dateTime=" + dateTime + ", room=" + room + ", remainingSeats=" + remainingSeats + ", movieDto=" + movieDto + '}';
    }

    
    
    
}
