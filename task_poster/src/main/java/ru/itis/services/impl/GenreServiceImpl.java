package ru.itis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dao.GenreDao;
import ru.itis.models.Genre;
import ru.itis.services.GenreService;

import java.util.List;

/**
 * 12.06.2017
 * GenreServiceImpl @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */
@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreDao genreDao;

    @Override
    public List<Genre> getAll() {
        return genreDao.findAll();
    }
}
