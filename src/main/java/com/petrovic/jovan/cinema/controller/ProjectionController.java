/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.controller;

import com.petrovic.jovan.cinema.dto.Genre;
import com.petrovic.jovan.cinema.dto.MovieDto;
import com.petrovic.jovan.cinema.dto.ProjectionDto;
import com.petrovic.jovan.cinema.service.MovieService;
import com.petrovic.jovan.cinema.service.ProjectionService;
import com.petrovic.jovan.cinema.validator.ProjectionValidator;
import java.sql.Timestamp;
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
@RequestMapping(value = "/projection")
public class ProjectionController {
    
    private final ProjectionService projectionService;
    private final ProjectionValidator projectionValidator;
    private final MovieService movieService;

    @Autowired
    public ProjectionController(ProjectionService projectionService, ProjectionValidator projectionValidator, MovieService movieService) {
        this.projectionService = projectionService;
        this.projectionValidator = projectionValidator;
        this.movieService = movieService;
    }
    
    @GetMapping
    public String home() {
        System.out.println("====================================================================");
        System.out.println("====================   ProjectionController: home()    ===================");
        System.out.println("====================================================================");
        return "projection/home";
    }
    
    @GetMapping(value = "add")
    public ModelAndView add() {
        System.out.println("====================================================================");
        System.out.println("====================   ProjectionController: add()     ===================");
        System.out.println("====================================================================");

        ModelAndView modelAndView = new ModelAndView("projection/add");
        return modelAndView;
    }
    
    @GetMapping(value = "all")
    public ModelAndView getAll() {
        System.out.println("====================================================================");
        System.out.println("====================   ProjectionController: all()     ===================");
        System.out.println("====================================================================");
        ModelAndView modelAndView = new ModelAndView("projection/all");
        modelAndView.addObject("message", "All projections!");
        return modelAndView;
    }
    
    @PostMapping(value = "save")
    public String save(@ModelAttribute(name = "projectionDto") @Validated ProjectionDto projectionDto, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("===================================================================================");
        System.out.println("====================   ProjectionController: save(@ModelAttribute)    ==================");
        System.out.println("===================================================================================");
        System.out.println(projectionDto);
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            model.addAttribute("invalid", "One or more fields are invalid");
            model.addAttribute("projectionDto", projectionDto);
            return "projection/add";
        } else {
            projectionService.save(projectionDto);
            redirectAttributes.addFlashAttribute("messageProjection", "Projection is saved");
            return "redirect:/projection/add";
        }
    }
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(projectionValidator);
    }
    
    @GetMapping(value = "/{id}/view")
    public ModelAndView view(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("projection/view");
        modelAndView.addObject("message", "Projection " + id + "!");
        modelAndView.addObject("projectionDto", projectionService.findByNumber(id));
        return modelAndView;
    }
    
    @GetMapping(value = "/{id}/delete")
    public ModelAndView delete(@PathVariable(name = "id") Long id) {
        System.out.println("Delete..." + id);
        projectionService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/projection/all");
        modelAndView.addObject("message", "Projection " + id + " is deleted!");
        return modelAndView;
    }
    
    @ModelAttribute(name = "projections")
    private List<ProjectionDto> getProjections() {
        return projectionService.getAll();
    }
    
    @ModelAttribute(name = "projectionDto")
    private ProjectionDto getProjectionDto() {
        return new ProjectionDto(0L, new Timestamp(System.currentTimeMillis()), "", 0, new MovieDto());
    }
    
    @ModelAttribute(name = "movies")
    private List<MovieDto> getCities() {
        return movieService.getAll();
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
