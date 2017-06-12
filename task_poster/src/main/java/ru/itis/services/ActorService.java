package ru.itis.services;

import ru.itis.models.Film;

import java.util.Set;

/**
 * 12.06.2017
 * ActorService @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */
public interface ActorService {
    Set<Film> getFilmsByActor(String actorName);
}
