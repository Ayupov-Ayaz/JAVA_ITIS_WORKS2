package ru.itis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dao.ActorsDao;
import ru.itis.models.Actor;
import ru.itis.models.Film;
import ru.itis.services.ActorService;

import java.util.List;
import java.util.Set;

/**
 * 12.06.2017
 * ActorServiceImpl @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */
@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    private ActorsDao actorsDao;

    @Override
    public Set<Film> getFilmsByActor(String actorName) {
        return actorsDao.findFilmByActor(actorName);
    }

    @Override
    public List<Actor> getAllActors() {
        return actorsDao.findAll();
    }

    @Override
    public int register(Actor actor) {
       return actorsDao.save(actor);
    }

    @Override
    public int getIdActorByName(String actorName) {
        return actorsDao.getIdActorByName(actorName);
    }


}
