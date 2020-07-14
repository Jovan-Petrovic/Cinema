/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Bron Zilar
 */
@Entity
@DiscriminatorValue(value = "DIRECTOR")
public class Director extends MovieWorker implements Serializable {

    @ManyToMany(mappedBy = "directors")
    private List<Movie> movies;
    
    public Director() {
        super();
        movies = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Director{" + "id=" + getId() + ", name=" + getName() + ", nationality=" + getNationality() + '}';
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    
    
    
}
