/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petrovic.jovan.cinema.dto.ActorDto;
import com.petrovic.jovan.cinema.dto.DirectorDto;
import com.petrovic.jovan.cinema.dto.Genre;
import com.petrovic.jovan.cinema.dto.MovieDto;
import com.petrovic.jovan.cinema.dto.MovieSaveDto;
import com.petrovic.jovan.cinema.service.ActorService;
import com.petrovic.jovan.cinema.service.DirectorService;
import com.petrovic.jovan.cinema.service.MovieService;
import com.petrovic.jovan.cinema.validator.MovieValidator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
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
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Bron Zilar
 */
@Controller
@RequestMapping(value = "/movie")
public class MovieController {

    private final ObjectMapper mapper = new ObjectMapper();

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

    @PostMapping(value = "save", consumes = APPLICATION_JSON_VALUE)
//    @PostMapping(value = "save", consumes = APPLICATION_JSON_VALUE)
//    public String save(@ModelAttribute(name = "movieSaveDto") @Validated MovieDto movieSaveDto, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
    public String save(HttpServletRequest request, @RequestBody String movieDtoJson, RedirectAttributes redirectAttributes) {
        System.out.println("===================================================================================");
        System.out.println("====================   MovieController: save(@ModelAttribute)    ==================");
        System.out.println("===================================================================================");
//        System.out.println(movieDtoJson);
        try {
            MovieSaveDto movieSaveDto = mapper.readValue(movieDtoJson, MovieSaveDto.class);
            System.out.println(movieSaveDto);
            movieService.save(movieSaveDto);
            redirectAttributes.addFlashAttribute("message", "Movie is saved");
        } catch (JsonProcessingException ex) {
            System.out.println(ex.getMessage());
        }

//        ModelAndView modelAndView = new ModelAndView();
//        if (result.hasErrors()) {
//            model.addAttribute("invalid", "One or more fields are invalid");
//            model.addAttribute("movieSaveDto", movieSaveDto);
//            return "movie/add";
//        } else {
//            movieService.save(movieSaveDto);
//            redirectAttributes.addFlashAttribute("message", "Movie is saved");
//            return "redirect:/movie/add";
//        }
        return "redirect:/movie/add";
    }
    
    @PostMapping(value = "update")
    public String update(@ModelAttribute(name = "movieDto") MovieDto movieDto, RedirectAttributes redirectAttributes) {
        System.out.println("===================================================================================");
        System.out.println("====================   MovieController: update(@ModelAttribute)    ==================");
        System.out.println("===================================================================================");
        System.out.println(movieDto);
        movieService.saveOrUpdate(movieDto);
        redirectAttributes.addFlashAttribute("messageMovie", "Movie is updated");
        return "redirect:/movie/all";

    }
    
    @GetMapping(value = "/{id}/updateView")
    public ModelAndView update(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("movie/update");
        modelAndView.addObject("messageMovie", "Movie " + id + "!");
        modelAndView.addObject("movieDto", movieService.findByNumber(id));
        return modelAndView;
    }

//    @InitBinder
//    private void initBinder(WebDataBinder binder) {
//        binder.setValidator(movieValidator);
//    }
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
        ModelAndView modelAndView = new ModelAndView("redirect:/movie/all");
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
