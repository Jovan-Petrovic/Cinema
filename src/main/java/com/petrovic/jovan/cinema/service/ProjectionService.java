/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.service;

import com.petrovic.jovan.cinema.dto.ProjectionDto;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public interface ProjectionService {
    List<ProjectionDto> getAll();

    public ProjectionDto findByNumber(Long id);

    public void delete(Long id);

    public ProjectionDto findByName(String name);

    public void save(ProjectionDto projectionDto);
}
