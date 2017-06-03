package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.models.Film;
import ru.itis.services.AfishaService;

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


    @GetMapping("films/{film-id}")
    public String getFilm(@ModelAttribute("model") ModelMap model, @PathVariable("film-id") int filmId){
        List<Film> films = afishaService.findAll();
        Film film = films.get(filmId);
        model.addAttribute("filmView",films);
        return "filmView";
    }
    @GetMapping("films/all")
    public String getAll(@ModelAttribute("model") ModelMap model){
        List<Film> films = afishaService.findAll();
        model.addAttribute("filmView",films);
        return "filmView";
    }

}
