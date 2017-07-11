package ru.itis.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.models.Actor;
import ru.itis.models.Genre;
import ru.itis.services.ActorService;
import ru.itis.services.GenreService;
import java.util.ArrayList;
import java.util.List;


/**
 * 15.06.2017
 * AddController
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class AddFilmController {

    @Autowired
    private GenreService genreService;

    @Autowired
    private ActorService actorService;

    @RequestMapping(value = "films/admin/new", method = RequestMethod.GET)
    public String newFilm(@ModelAttribute("model") ModelMap model){
        List<Genre> genres = genreService.getAll();
        model.addAttribute("genres",genres);
        return "/WEB-INF/view/ftl/newFilmView.jsp";
    }

    @RequestMapping(value="/films/admin/add", method = RequestMethod.POST)
    public String addNewFilm(@ModelAttribute("model") ModelMap model,
                             @ModelAttribute("name") String name,
                             @ModelAttribute("releaseDate") String releaseDate,
                             @ModelAttribute("lasting") String lasting,
                             @ModelAttribute("country") String country,
                             @ModelAttribute("producer") String producer,
                             @ModelAttribute("description") String description,
                             @ModelAttribute("actors") String actors,
                             @RequestParam("genres") List<String> genres){
        int  filmLasting = Integer.parseInt(lasting);
        String[] filmActor = actors.split(",");
        List<Integer> idActorsInFilm = new ArrayList<>();
        for(String actorName: filmActor){
            int actorId = actorService.getIdActorByName(actorName);
            if( actorId == -1){
                Actor newActor = new Actor.Builder()
                        .actorName(actorName).build();
                actorId = actorService.register(newActor);
                idActorsInFilm.add(actorId);
            }else{
                idActorsInFilm.add(actorId);
            }
        }


        return ",kf,kf";



    }





}
