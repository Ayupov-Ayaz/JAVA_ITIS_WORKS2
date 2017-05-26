package ru.itis.controller.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.models.Film;
import ru.itis.services.AfishaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class FilmsController implements Controller {
    @Autowired
    private AfishaService afishaService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if(httpServletRequest.getMethod().equals("GET")){
            ModelAndView result = new ModelAndView("filmsView");
            List<Film> films = afishaService.findAll();
            result.addObject("filmsModel",films);
            return result;
        }else throw new IllegalArgumentException("BAD REQUEST");
    }
}
