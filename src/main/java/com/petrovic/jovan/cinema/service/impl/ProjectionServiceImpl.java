/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.service.impl;

import com.petrovic.jovan.cinema.converter.ProjectionConverter;
import com.petrovic.jovan.cinema.dto.ProjectionDto;
import com.petrovic.jovan.cinema.entity.Projection;
import com.petrovic.jovan.cinema.repository.ProjectionRepository;
import com.petrovic.jovan.cinema.service.MovieService;
import com.petrovic.jovan.cinema.service.ProjectionService;
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
public class ProjectionServiceImpl implements ProjectionService{

    @Autowired
    private ProjectionRepository projectionRepository;
    
    @Override
    public List<ProjectionDto> getAll() {
        List<Projection> projections = projectionRepository.findAll();
        List<ProjectionDto> projectionDtos = new ArrayList<>();
        for (Projection projection : projections) {
            projectionDtos.add(ProjectionConverter.convertFromEntityToDto(projection));
        }
        return projectionDtos;
    }

    @Override
    public ProjectionDto findByNumber(Long id) {
        Projection projection = projectionRepository.getById(id);
        ProjectionDto projectionDto = ProjectionConverter.convertFromEntityToDto(projection);
        System.out.println(projectionDto);
        return projectionDto;
    }

    @Override
    public void delete(Long id) {
        projectionRepository.deleteById(id);
    }

    @Override
    public ProjectionDto findByName(String name) {
        return new ProjectionDto();
    }

    @Override
    public void save(ProjectionDto projectionDto) {
        projectionRepository.save(ProjectionConverter.convertFromDtoToEntity(projectionDto));
    }

    @Override
    public void saveOrUpdate(ProjectionDto projectionDto) {
        Projection projection = ProjectionConverter.convertFromDtoToEntity(projectionDto);
        projectionRepository.save(projection);
    }
    
}
