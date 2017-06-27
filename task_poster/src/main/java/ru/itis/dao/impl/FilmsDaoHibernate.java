package ru.itis.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.itis.dao.FilmsDao;
import ru.itis.models.Film;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * 01.06.2017
 * FilmsDaoHibernate
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Repository
public class FilmsDaoHibernate implements FilmsDao {

    private final static String JPA_FIND_ALL = "SELECT f FROM Film f ";
    //f JOIN f.genres g JOIN f.actors a


    @PersistenceContext
    private EntityManager entityManager;


    public FilmsDaoHibernate() {
    }


    @Override
    public Film find(int id) {
       return entityManager.createQuery(JPA_FIND_ALL +" where id = :id", Film.class)
                .setParameter("id", id).getSingleResult();

    }

    @Override
    public int save(Film model) {
        entityManager.persist(model);
        entityManager.flush();
        return model.getId();
    }

    @Override
    public void update(Film model) {
        entityManager.merge(model);
    }

    @Override
    public void delete(int id) {
        Film film = find(id);
       entityManager.remove(film);
    }

    @Override
    public List<Film> findAll() {

        List<Film> films = entityManager.createQuery(JPA_FIND_ALL, Film.class).getResultList();
        return films;
    }

    @Override
    public Film findByName(String name) {
       return  entityManager.createQuery(JPA_FIND_ALL + "WHERE name = :name",Film.class)
               .setParameter("name",name).getSingleResult();
    }

    @Override
    public List<Film> findByCountry(String country) {
        return entityManager.createQuery(JPA_FIND_ALL + "WHERE country = :country",Film.class)
                .setParameter("country",country).getResultList();
    }

    @Override
    public List<Film> findByProducer(String producer) {
        return entityManager.createQuery(JPA_FIND_ALL + "where producer = :producer",Film.class)
                .setParameter("producer",producer).getResultList();
    }

}
