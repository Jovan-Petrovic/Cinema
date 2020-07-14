/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.formatter;

import com.petrovic.jovan.cinema.dto.ActorDto;
import com.petrovic.jovan.cinema.service.ActorService;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

/**
 *
 * @author Bron Zilar
 */
public class ActorDtoFormatter implements Formatter<ActorDto> {

    private final ActorService actorService;

    @Autowired
    public ActorDtoFormatter(ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    public String print(ActorDto actorDto, Locale locale) {
        return actorDto.toString();
    }

    @Override
    public ActorDto parse(String name, Locale locale) throws ParseException {
        System.out.println("==============================================");
        System.out.println("ActorDtoFormatter: Actor actor -> " + name);
        return actorService.findByName(name);
    }
    
}
