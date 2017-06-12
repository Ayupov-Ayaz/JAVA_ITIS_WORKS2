package ru.itis.dao;

import ru.itis.models.Film;
import ru.itis.models.Genre;

import java.util.List;
import java.util.Set;

/**
 * 12.06.2017
 * GenreDao @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */
public interface GenreDao extends BaseDao<Genre>{
    Set<Film> findFilmByGenre(String genre);
}
