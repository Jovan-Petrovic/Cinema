/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.validator;

import com.petrovic.jovan.cinema.dto.MovieDto;
import com.petrovic.jovan.cinema.dto.ProjectionDto;
import com.petrovic.jovan.cinema.service.ProjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Bron Zilar
 */
@Component
public class ProjectionValidator implements Validator {

    private final ProjectionService projectionService;

    @Autowired
    public ProjectionValidator(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @Override
    public boolean supports(Class<?> type) {
       return ProjectionDto.class.equals(type);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProjectionDto projectionDto = (ProjectionDto) target;
        
        System.out.println("Validating projection: " + projectionDto);
        
        System.out.println("000000000");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateTime", "projectionDto.dateTime.empty", "projectionDto.dateTime.empty = Default message");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "room", "projectionDto.room.empty", "projectionDto.room.empty = Default message");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remainingSeats", "projectionDto.remainingSeats.empty", "projectionDto.remainingSeats.empty = Default message");
        
        System.out.println("1111111111111");
        
        if (errors.hasErrors()) {
            System.out.println("222222222222");
            return;
        }
        
        if (projectionDto.getRemainingSeats() < 0) {
            System.out.println("3333333333333");
            errors.rejectValue("remainingSeats", "projectionDto.remainingSeats.size", "projectionDto.remainingSeats.size = Default message");
        }
        
        System.out.println("44444444444444");
    }
    
}
