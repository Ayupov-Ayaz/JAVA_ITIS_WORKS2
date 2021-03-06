package ru.itis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dao.FilmsDao;
import ru.itis.models.Film;
import ru.itis.services.AfishaService;

import java.util.List;


@Service
public class AfishaServiceImpl implements AfishaService {

    @Autowired
    private FilmsDao filmsDao;



    @Override
    public void register(Film film) {
        filmsDao.save(film);
    }

    @Override
    public Film findById(int id) {
        return filmsDao.find(id);
    }

    @Override
    public Film findByName(String name) {
        return filmsDao.findByName(name);
    }

    @Override
    public List<Film> findByCountry(String country) {
        return filmsDao.findByCountry(country);
    }

    @Override
    public List<Film> findByProducer(String producer) {
        return filmsDao.findByProducer(producer);
    }

    @Override
    public List<Film> findAll() {
        return filmsDao.findAll();
    }
}
