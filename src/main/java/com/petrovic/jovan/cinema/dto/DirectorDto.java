/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public class DirectorDto extends MovieWorkerDto implements Serializable {

    private List<MovieDto> movieDtos;
    
    public DirectorDto() {
        super();
        movieDtos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "DirectorDto{" + "id=" + getId() + ", name=" + getName() + ", nationality=" + getNationality() + '}';
    }

    public List<MovieDto> getMovieDtos() {
        return movieDtos;
    }

    public void setMovieDtos(List<MovieDto> movieDtos) {
        this.movieDtos = movieDtos;
    }  
    
}
