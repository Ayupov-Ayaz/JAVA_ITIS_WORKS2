package ru.itis.services;

import ru.itis.models.Actor;
import ru.itis.models.Film;

import java.util.List;
import java.util.Set;

/**
 * 12.06.2017
 * ActorService @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */
public interface ActorService {
    Set<Film> getFilmsByActor(String actorName);

    List<Actor> getAllActors();

    int register(Actor actor);

    int getIdActorByName(String actorName);
}
