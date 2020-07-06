/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.service;

import com.petrovic.jovan.cinema.dto.MovieDto;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public interface MovieService {
    List<MovieDto> getAll();

    public Object findByNumber(Long id);

    public void delete(Long id);

    public MovieDto findByName(String name);

    public void save(MovieDto movieDto);
    
}
