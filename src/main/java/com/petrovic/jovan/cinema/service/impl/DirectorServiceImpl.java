/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.service.impl;

import com.petrovic.jovan.cinema.converter.MovieWorkerConverter;
import com.petrovic.jovan.cinema.dto.DirectorDto;
import com.petrovic.jovan.cinema.entity.Director;
import com.petrovic.jovan.cinema.repository.DirectorRepository;
import com.petrovic.jovan.cinema.service.DirectorService;
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
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRepository;
    
    @Override
    public DirectorDto findByName(String name) {
        DirectorDto directorDto = MovieWorkerConverter.convertDirectorFromEntityToDto(directorRepository.findByName(name));
        return directorDto;
    }

    @Override
    public List<DirectorDto> getAll() {
        List<Director> directors = directorRepository.findAll();
        List<DirectorDto> directorDtos = new ArrayList<>();
        for (Director director : directors) {
            directorDtos.add(MovieWorkerConverter.convertDirectorFromEntityToDto(director));
        }
        return directorDtos;
    }
    
}
