/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.controller;

import com.petrovic.jovan.cinema.dto.Genre;
import com.petrovic.jovan.cinema.dto.MovieDto;
import com.petrovic.jovan.cinema.service.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Bron Zilar
 */
@Controller
@RequestMapping(value = "/movie")
public class MovieController {
    
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String home() {
        System.out.println("====================================================================");
        System.out.println("====================   MovieController: home()    ===================");
        System.out.println("====================================================================");
        return "movie/home";
    }
    
    @GetMapping(value = "add")
    public ModelAndView add() {
        System.out.println("====================================================================");
        System.out.println("====================   MovieController: add()     ===================");
        System.out.println("====================================================================");

        ModelAndView modelAndView = new ModelAndView("movie/add");
        return modelAndView;
    }
    
    @GetMapping(value = "all")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("movie/all");
        modelAndView.addObject("message", "All movies!");
        return modelAndView;
    }
    
    @ModelAttribute(name = "movies")
    private List<MovieDto> getCities() {
        return movieService.getAll();
    }
    
    @ModelAttribute(name = "movieDto")
    private MovieDto getCityDto() {
        return new MovieDto(0L, "/", 0, Genre.TRILER, 0, "/", 0d);
    }
    
    @ExceptionHandler(NullPointerException.class)
	public String exceptionHandler(NullPointerException nullPointerException,RedirectAttributes redirectAttributes) {
		
		System.out.println("====================================================================");
		System.out.println("@ControllerAdvice exception ocured: NullPointerException===========");
		System.out.println("====================================================================");
		
		redirectAttributes.addFlashAttribute("errorMessage", nullPointerException.getMessage());
		redirectAttributes.addFlashAttribute("errorObj", nullPointerException);
		
		return "redirect:/error/globalException";
	}
}
