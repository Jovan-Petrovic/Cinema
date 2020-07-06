/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Bron Zilar
 */
@Entity
@Table(name = "PROJECTION")
public class Projection implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PROJECTION")
    @TableGenerator(name = "PROJECTION", table = "GEN_ID", 
            pkColumnName = "PK_GEN",valueColumnName = "VALUE_GEN",
            pkColumnValue = "TBL_PROJECTION",
            initialValue = 0, allocationSize = 1)
    private Long id;

    private Timestamp dateTime;
    private String room;
    private int remainingSeats;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Projection() {
    }

    public Projection(Long id, Timestamp dateTime, String room, int remainingSeats, Movie movie) {
        this.id = id;
        this.dateTime = dateTime;
        this.room = room;
        this.remainingSeats = remainingSeats;
        this.movie = movie;
    }

    public Projection(Timestamp dateTime, String room, int remainingSeats, Movie movie) {
        this.dateTime = dateTime;
        this.room = room;
        this.remainingSeats = remainingSeats;
        this.movie = movie;
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

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.dateTime);
        hash = 59 * hash + Objects.hashCode(this.room);
        hash = 59 * hash + this.remainingSeats;
        hash = 59 * hash + Objects.hashCode(this.movie);
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
        final Projection other = (Projection) obj;
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
        if (!Objects.equals(this.movie, other.movie)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Projection{" + "id=" + id + ", dateTime=" + dateTime + ", room=" + room + ", remainingSeats=" + remainingSeats + ", movie=" + movie + '}';
    }
    
    
}
