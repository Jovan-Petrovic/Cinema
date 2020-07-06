/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.converter;

import com.petrovic.jovan.cinema.dto.Genre;
import com.petrovic.jovan.cinema.dto.MovieDto;
import com.petrovic.jovan.cinema.entity.Movie;

/**
 *
 * @author Bron Zilar
 */
public class MovieConverter {
    
    public static MovieDto convertFromEntityToDto(Movie movie) {
        MovieDto movieDto = new MovieDto(movie.getId(), movie.getTitle(), movie.getDuration(), movie.getGenre(), movie.getYear(), movie.getLanguage(), movie.getRatingIMDb());
        return movieDto;
    }
    
    public static Movie convertFromDtoToEntity(MovieDto movieDto) {
        Movie movie = new Movie(movieDto.getId(), movieDto.getTitle(), movieDto.getDuration(), movieDto.getGenre(), movieDto.getYear(), movieDto.getLanguage(), movieDto.getRatingIMDb());
        return movie;
    }
}
