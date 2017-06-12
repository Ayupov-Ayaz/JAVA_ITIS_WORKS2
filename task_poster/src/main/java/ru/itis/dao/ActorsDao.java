package ru.itis.dao;

import ru.itis.models.Actor;
import ru.itis.models.Film;

import java.util.Set;

/**
 * 12.06.2017
 * ActorsDao @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */
public interface ActorsDao extends BaseDao<Actor> {
    Set<Film> findFilmByActor(String actor);
}
