/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.formatter;

import com.petrovic.jovan.cinema.dto.MovieDto;
import com.petrovic.jovan.cinema.service.MovieService;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

/**
 *
 * @author Bron Zilar
 */
public class MovieDtoFormatter implements Formatter<MovieDto> {

    private final MovieService movieService;

    @Autowired
    public MovieDtoFormatter(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public String print(MovieDto movieDto, Locale locale) {
        return movieDto.toString();
    }

    @Override
    public MovieDto parse(String title, Locale locale) throws ParseException {
        System.out.println("==============================================");
        System.out.println("MovieDtoFormater: Movie title -> " + title);
        return movieService.findByTitle(title);
    }
    
}
