/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.converter;

import com.petrovic.jovan.cinema.dto.ActorDto;
import com.petrovic.jovan.cinema.dto.DirectorDto;
import com.petrovic.jovan.cinema.dto.MovieWorkerDto;
import com.petrovic.jovan.cinema.entity.Actor;
import com.petrovic.jovan.cinema.entity.Director;
import com.petrovic.jovan.cinema.entity.MovieWorker;

/**
 *
 * @author Bron Zilar
 */
public class MovieWorkerConverter {
    
    public static DirectorDto convertDirectorFromEntityToDto(Director director) {
        DirectorDto directorDto = new DirectorDto();
        directorDto.setId(director.getId());
        directorDto.setName(director.getName());
        directorDto.setNationality(director.getNationality());
        return directorDto;
    }
    
    public static Director convertDirectorFromDtoToEntity(DirectorDto directorDto) {
        Director director = new Director();
        director.setId(directorDto.getId());
        director.setName(directorDto.getName());
        director.setNationality(directorDto.getNationality());
        return director;
    }
    
    public static ActorDto convertActorFromEntityToDto(Actor actor) {
        ActorDto actorDto = new ActorDto();
        actorDto.setId(actor.getId());
        actorDto.setName(actor.getName());
        actorDto.setNationality(actor.getNationality());
        return actorDto;
    }
    
    public static Actor convertActorFromDtoToEntity(ActorDto actorDto) {
        Actor actor = new Actor();
        actor.setId(actorDto.getId());
        actor.setName(actorDto.getName());
        actor.setNationality(actorDto.getNationality());
        return actor;
    }
    
    
}
