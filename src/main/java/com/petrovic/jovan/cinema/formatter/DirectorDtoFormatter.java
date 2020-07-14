/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.formatter;

import com.petrovic.jovan.cinema.dto.DirectorDto;
import com.petrovic.jovan.cinema.service.DirectorService;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

/**
 *
 * @author Bron Zilar
 */
public class DirectorDtoFormatter implements Formatter<DirectorDto> {

    private final DirectorService directorService;

    @Autowired
    public DirectorDtoFormatter(DirectorService directorService) {
        this.directorService = directorService;
    }
    
    @Override
    public String print(DirectorDto directorDto, Locale locale) {
        return directorDto.toString();
    }

    @Override
    public DirectorDto parse(String name, Locale locale) throws ParseException {
        System.out.println("==============================================");
        System.out.println("DirectorDtoFormatter: Director director -> " + name);
        return directorService.findByName(name);
    }
    
}
