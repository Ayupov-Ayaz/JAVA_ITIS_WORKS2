package ru.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;

/**
 * 15.06.2017
 * AddController
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class AddController{

    @RequestMapping(value="/films/admin/add", method = RequestMethod.POST)
    public String addNewFilm(@ModelAttribute("model") ModelMap model){


        return "yes";
    }


}
