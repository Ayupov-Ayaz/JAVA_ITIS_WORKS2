package ru.itis.controller.annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Film;
import ru.itis.services.AfishaService;

import java.util.List;

@Controller("filmsContollerAnnotation")
public class FilmsController {

    @Autowired
    AfishaService afishaService;

    @RequestMapping(value = "/films/all", method = RequestMethod.GET)
    public String getAll(@ModelAttribute("model")ModelMap model){
        List<Film> films = afishaService.findAll();
        model.addAttribute("films",films);
        return "films";
    }




}
