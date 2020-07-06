/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.validator;

import com.petrovic.jovan.cinema.dto.MovieDto;
import com.petrovic.jovan.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Bron Zilar
 */
@Component
public class MovieValidator implements Validator {
    
    private final MovieService movieService;

    @Autowired
    public MovieValidator(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public boolean supports(Class<?> type) {
        return MovieDto.class.equals(type);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MovieDto movieDto = (MovieDto) target;
        
        System.out.println("Validating movie: " + movieDto);
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "movieDto.title.empty", "movieDto.title.empty = Default message");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "duration", "movieDto.duration.empty", "movieDto.duration.empty = Default message");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "movieDto.genre.empty", "movieDto.genre.empty = Default message");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "movieDto.year.empty", "movieDto.year.empty = Default message");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "language", "movieDto.language.empty", "movieDto.language.empty = Default message");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ratingIMDb", "movieDto.ratingIMDb.empty", "movieDto.ratingIMDb.empty = Default message");
        
        if (errors.hasErrors()) {
            return;
        }
        
        if (movieDto.getTitle().length() < 2) {
            errors.rejectValue("title", "movieDto.title.size", "movieDto.title.size = Default message");
        }
        
    }
    
}
