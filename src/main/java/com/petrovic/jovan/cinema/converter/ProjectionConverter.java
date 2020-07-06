/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.converter;

import com.petrovic.jovan.cinema.dto.MovieDto;
import com.petrovic.jovan.cinema.dto.ProjectionDto;
import com.petrovic.jovan.cinema.entity.Movie;
import com.petrovic.jovan.cinema.entity.Projection;

/**
 *
 * @author Bron Zilar
 */
public class ProjectionConverter {
    
    public static ProjectionDto convertFromEntityToDto(Projection projection) {
        MovieDto movieDto = MovieConverter.convertFromEntityToDto(projection.getMovie());
        ProjectionDto projectionDto = new ProjectionDto(projection.getId(), projection.getDateTime(), projection.getRoom(), projection.getRemainingSeats(), movieDto); 
        return projectionDto;
    }
    
    public static Projection convertFromDtoToEntity(ProjectionDto projectionDto) {
        Movie movie = MovieConverter.convertFromDtoToEntity(projectionDto.getMovieDto());
        Projection projection = new Projection(projectionDto.getId(), projectionDto.getDateTime(), projectionDto.getRoom(), projectionDto.getRemainingSeats(), movie); 
        return projection;
    }
}
