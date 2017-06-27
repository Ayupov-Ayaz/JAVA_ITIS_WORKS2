package ru.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 27.06.2017
 * LoginController
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(method= RequestMethod.GET)
    public String loginPage(Model model){
        return "login";
    }
}
