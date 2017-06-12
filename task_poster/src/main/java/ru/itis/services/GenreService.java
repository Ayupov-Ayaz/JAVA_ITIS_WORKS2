package ru.itis.services;

import ru.itis.models.Film;
import ru.itis.models.Genre;

import java.util.List;
import java.util.Set;

/**
 * 12.06.2017
 * GenreService @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */
public interface GenreService {

    List<Genre> getAll();
    Set<Film> findFilmByGenre(String genre);
}
