/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.controller;

import com.petrovic.jovan.cinema.dto.ActorDto;
import com.petrovic.jovan.cinema.dto.DirectorDto;
import com.petrovic.jovan.cinema.dto.Genre;
import com.petrovic.jovan.cinema.dto.MovieDto;
import com.petrovic.jovan.cinema.service.ActorService;
import com.petrovic.jovan.cinema.service.DirectorService;
import com.petrovic.jovan.cinema.service.MovieService;
import com.petrovic.jovan.cinema.validator.MovieValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private final MovieValidator movieValidator;
    private final DirectorService directorService;
    private final ActorService actorService;

    @Autowired
    public MovieController(MovieService movieService, MovieValidator movieValidator, DirectorService directorService, ActorService actorService) {
        this.movieService = movieService;
        this.movieValidator = movieValidator;
        this.directorService = directorService;
        this.actorService = actorService;
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
        System.out.println("====================================================================");
        System.out.println("====================   MovieController: all()     ===================");
        System.out.println("====================================================================");
        ModelAndView modelAndView = new ModelAndView("movie/all");
        modelAndView.addObject("message", "All movies!");
        return modelAndView;
    }
    
    @PostMapping(value = "save")
    public String save(@ModelAttribute(name = "movieDto") @Validated MovieDto movieDto, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("===================================================================================");
        System.out.println("====================   MovieController: save(@ModelAttribute)    ==================");
        System.out.println("===================================================================================");
        System.out.println(movieDto);
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            model.addAttribute("invalid", "One or more fields are invalid");
            model.addAttribute("movieDto", movieDto);
            return "movie/add";
        } else {
            movieService.save(movieDto);
            redirectAttributes.addFlashAttribute("message", "Movie is saved");
            return "redirect:/movie/add";
        }
    }
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(movieValidator);
    }
    
    @GetMapping(value = "/{id}/view")
    public ModelAndView view(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("movie/view");
        modelAndView.addObject("message", "Movie " + id + "!");
        modelAndView.addObject("movieDto", movieService.findByNumber(id));
        return modelAndView;
    }

    @GetMapping(value = "/{id}/delete")
    public ModelAndView delete(@PathVariable(name = "id") Long id) {
        System.out.println("Delete..." + id);
        movieService.delete(id);
        ModelAndView modelAndView = new ModelAndView("movie/all");
        modelAndView.addObject("message", "Movie " + id + " is deleted!");
        return modelAndView;
    }
    
    @ModelAttribute(name = "movies")
    private List<MovieDto> getMovies() {
        return movieService.getAll();
    }
    
    @ModelAttribute(name = "movieDto")
    private MovieDto getCityDto() {
        return new MovieDto(0L, "/", 0, Genre.TRILER, 0, "/", 0d);
    }
    
    @ModelAttribute(name = "directors")
    private List<DirectorDto> getDirectors() {
        return directorService.getAll();
    }
    
    @ModelAttribute(name = "actors")
    private List<ActorDto> getActors() {
        return actorService.getAll();
    }
    
    /*
    @ExceptionHandler(NullPointerException.class)
	public String exceptionHandler(NullPointerException nullPointerException,RedirectAttributes redirectAttributes) {
		
		System.out.println("====================================================================");
		System.out.println("@ControllerAdvice exception ocured: NullPointerException===========");
		System.out.println("====================================================================");
		
		redirectAttributes.addFlashAttribute("errorMessage", nullPointerException.getMessage());
		redirectAttributes.addFlashAttribute("errorObj", nullPointerException);
		
		return "redirect:/error/globalException";
	}*/
}
