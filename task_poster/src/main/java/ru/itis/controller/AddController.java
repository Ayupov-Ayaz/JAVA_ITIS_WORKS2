package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.models.Genre;
import ru.itis.services.GenreService;

import javax.enterprise.inject.Model;
import java.util.List;

/**
 * 15.06.2017
 * AddController
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class AddController{

    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "films/admin/new", method = RequestMethod.GET)
    public String newFilm(@ModelAttribute("model") ModelMap model){
        List<Genre> genres = genreService.getAll();
        model.addAttribute("genres",genres);
        return "newFilmView";
    }

    @RequestMapping(value="/films/admin/add", method = RequestMethod.POST)
    public String addNewFilm(@ModelAttribute("model") ModelMap model,
                             @ModelAttribute("name") String name,
                             @ModelAttribute("releaseDate") String release,
                             @ModelAttribute("lasting") int lasting,
                             @ModelAttribute("country") String country,
                             @ModelAttribute("producer") String producer,
                             @ModelAttribute("description") String description,
                             @ModelAttribute("actors") String actors,
                             @ModelAttribute("genres") String[] genres){
        String q_name = name;
        String q_releaseDate = release;

    }





}
