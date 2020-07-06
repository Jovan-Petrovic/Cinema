/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.service.impl;

import com.petrovic.jovan.cinema.converter.MovieConverter;
import com.petrovic.jovan.cinema.dto.Genre;
import com.petrovic.jovan.cinema.dto.MovieDto;
import com.petrovic.jovan.cinema.entity.Movie;
import com.petrovic.jovan.cinema.repository.MovieRepository;
import com.petrovic.jovan.cinema.service.MovieService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bron Zilar
 */
@Service
@Transactional
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieDto> getAll() {
        List<Movie> movies = movieRepository.findAll();
        // ToDo: napraviti konverter iz ENTITY u DTO
        List<MovieDto> movieDtos = new ArrayList<>();
        for (Movie movie : movies) {
            movieDtos.add(new MovieDto(movie.getId(), movie.getTitle(), movie.getDuration(), movie.getGenre(), movie.getYear(), movie.getLanguage(), movie.getRatingIMDb()));
        }
        return movieDtos;
    }

    @Override
    public MovieDto findByNumber(Long id) {
        Movie movie = movieRepository.getById(id);
        MovieDto movieDto = new MovieDto(movie.getId(), movie.getTitle(), movie.getDuration(), movie.getGenre(), movie.getYear(), movie.getLanguage(), movie.getRatingIMDb());
        return movieDto;
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieDto findByTitle(String title) {
        Movie movie = movieRepository.findByTitle(title);
        System.out.println(movie);
        MovieDto movieDto = MovieConverter.convertFromEntityToDto(movie);
        return movieDto;
    }

    @Override
    public void save(MovieDto movieDto) {
        movieRepository.save(new Movie(movieDto.getTitle(), movieDto.getDuration(), movieDto.getGenre(), movieDto.getYear(), movieDto.getLanguage(), movieDto.getRatingIMDb()));
    }

    
    
    
    
}
