package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.models.Film;
import ru.itis.models.Genre;
import ru.itis.services.AfishaService;
import ru.itis.services.GenreService;

import java.util.List;

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
    @RequestMapping(value = "films/new", method = RequestMethod.GET)
    public String newFilm(@ModelAttribute("model") ModelMap model){
        List<Genre> genres = genreService.getAll();
        model.addAttribute("genres",genres);
        return "newFilmView";
    }
}
