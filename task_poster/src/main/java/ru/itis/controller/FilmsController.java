package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.models.Film;
import ru.itis.models.Genre;
import ru.itis.services.ActorService;
import ru.itis.services.AfishaService;
import ru.itis.services.GenreService;

import javax.enterprise.inject.Model;
import java.util.List;
import java.util.Set;

/**
 * 02.06.2017
 * FilmsController
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class FilmsController {

    @Autowired
    private AfishaService afishaService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private ActorService actorService;


   @RequestMapping(value = "/films/{id}",method = RequestMethod.GET)
    public String getFilm(@ModelAttribute("model") ModelMap model, @PathVariable("id") int filmId){
        Film film = afishaService.findById(filmId);
        model.addAttribute("film",film);
        return "film";
    }
    @RequestMapping(value = "/films/all", method = RequestMethod.GET)
    public String getAll(@ModelAttribute("model") ModelMap model){
        List<Film> films = afishaService.findAll();
        model.addAttribute("filmsModel",films);
        return "filmsView";
    }

    @RequestMapping(value = "/films/producer/{producer}",method = RequestMethod.GET)
    public String getByProducer(@ModelAttribute("model") ModelMap model, @PathVariable("producer") String producer){
        List<Film> films = afishaService.findByProducer(producer);
        model.addAttribute("filmsModel",films);
        return "filmsView";
    }
    @RequestMapping(value = "/films/country/{country}",method = RequestMethod.GET)
    public String getByCountry(@ModelAttribute("model") ModelMap model, @PathVariable("country") String country){
        List<Film> films = afishaService.findByCountry(country);
        model.addAttribute("filmsModel",films);
        return "filmsView";
    }
    @RequestMapping(value = "/films/genre/{genre}",method = RequestMethod.GET)
    public String getByGenre(@ModelAttribute("model") ModelMap model, @PathVariable("genre") String genre){
        Set<Film> films = genreService.findFilmByGenre(genre);
        model.addAttribute("filmsModel",films);
        return "filmsView";
    }
    @RequestMapping(value = "/films/actor/{actor_name}",method = RequestMethod.GET)
    public String getByActor(@ModelAttribute("model") ModelMap model, @PathVariable("actor_name") String actorName){
        Set<Film> films = actorService.getFilmsByActor(actorName);
        model.addAttribute("filmsModel",films);
        return "filmsView";
    }




}
