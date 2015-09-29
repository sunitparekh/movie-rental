package com.github.sunitparekh.movierental.controllers;

import com.github.sunitparekh.movierental.models.Movie;
import com.github.sunitparekh.movierental.repositories.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class MovieController {

    @Resource
    MovieRepository repository;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ModelAndView findAll() {
        Iterable<Movie> movies = repository.findAll();
        return new ModelAndView("list_movies","movies",movies);
    }
}
