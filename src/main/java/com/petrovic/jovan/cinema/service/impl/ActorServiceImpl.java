/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.service.impl;

import com.petrovic.jovan.cinema.converter.MovieWorkerConverter;
import com.petrovic.jovan.cinema.dto.ActorDto;
import com.petrovic.jovan.cinema.entity.Actor;
import com.petrovic.jovan.cinema.repository.ActorRepository;
import com.petrovic.jovan.cinema.service.ActorService;
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
public class ActorServiceImpl implements ActorService {
    
    @Autowired
    private ActorRepository actorRepository;

    @Override
    public ActorDto findByName(String name) {
        ActorDto actorDto = MovieWorkerConverter.convertActorFromEntityToDto(actorRepository.findByName(name));
        return actorDto;
    }

    @Override
    public List<ActorDto> getAll() {
        List<Actor> actors = actorRepository.findAll();
        List<ActorDto> actorDtos = new ArrayList<>();
        for (Actor actor : actors) {
            actorDtos.add(MovieWorkerConverter.convertActorFromEntityToDto(actor));
        }
        return actorDtos;
    }
    
    
}
