/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.service;

import com.petrovic.jovan.cinema.dto.DirectorDto;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public interface DirectorService {
    
    List<DirectorDto> getAll();
    public DirectorDto findByName(String name);
    
}
