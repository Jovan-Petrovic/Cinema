/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.controller;

import com.petrovic.jovan.cinema.dto.MovieDto;
import com.petrovic.jovan.cinema.dto.ProjectionDto;
import com.petrovic.jovan.cinema.service.MovieService;
import com.petrovic.jovan.cinema.service.ProjectionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Bron Zilar
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    
    private final MovieService movieService;
    private final ProjectionService projectionService;

    @Autowired
    public UserController(MovieService movieService, ProjectionService projectionService) {
        this.movieService = movieService;
        this.projectionService = projectionService;
    }
  
    @GetMapping
    public String home() {
        System.out.println("====================================================================");
        System.out.println("====================   UserController: home()    ===================");
        System.out.println("====================================================================");
        return "user/home";
    }
    
    @GetMapping(value = "movie")
    public String homeUserMovie() {
        System.out.println("====================================================================");
        System.out.println("====================   UserController: homeMovie()    ===================");
        System.out.println("====================================================================");
        return "user/movie/home";
    }
    
    @GetMapping(value = "projection")
    public String homeUserProjection() {
        System.out.println("====================================================================");
        System.out.println("====================   UserController: homeProjection()    ===================");
        System.out.println("====================================================================");
        return "user/projection/home";
    }
    
    @GetMapping(value = "reservation")
    public String homeUserReservation() {
        System.out.println("====================================================================");
        System.out.println("====================   UserController: homeReservations()    ===================");
        System.out.println("====================================================================");
        return "user/reservation/home";
    }
    
    @GetMapping(value = "movie/all")
    public ModelAndView getAllMovies() {
        System.out.println("====================================================================");
        System.out.println("====================   UserController: allMovies()     ===================");
        System.out.println("====================================================================");
        ModelAndView modelAndView = new ModelAndView("user/movie/all");
        modelAndView.addObject("message", "All movies!");
        return modelAndView;
    }
    
    @GetMapping(value = "movie/{id}/view")
    public ModelAndView viewMovie(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("user/movie/view");
        modelAndView.addObject("message", "Movie " + id + "!");
        modelAndView.addObject("movieDto", movieService.findByNumber(id));
        return modelAndView;
    }
    
    @GetMapping(value = "projection/all")
    public ModelAndView getAllProjections() {
        System.out.println("====================================================================");
        System.out.println("====================   UserController: allProjections()     ===================");
        System.out.println("====================================================================");
        ModelAndView modelAndView = new ModelAndView("user/projection/all");
        modelAndView.addObject("message", "All projections!");
        return modelAndView;
    }
    
    @GetMapping(value = "projection/{id}/view")
    public ModelAndView viewProjection(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("user/projection/view");
        modelAndView.addObject("message", "Projection " + id + "!");
        modelAndView.addObject("projectionDto", projectionService.findByNumber(id));
        return modelAndView;
    }
    
    @ModelAttribute(name = "projections")
    private List<ProjectionDto> getProjections() {
        return projectionService.getAll();
    }
    
    @ModelAttribute(name = "movies")
    private List<MovieDto> getMovies() {
        return movieService.getAll();
    }
}
