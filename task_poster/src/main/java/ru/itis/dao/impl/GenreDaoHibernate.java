package ru.itis.dao.impl;

import org.springframework.stereotype.Repository;
import ru.itis.dao.BaseDao;
import ru.itis.dao.GenreDao;
import ru.itis.models.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * 12.06.2017
 * GenreDaoHibernate @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */
@Repository
public class GenreDaoHibernate implements GenreDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Genre find(int id) {
        return null;
    }

    @Override
    public int save(Genre model) {
        return 0;
    }

    @Override
    public void update(Genre model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Genre> findAll() {
       return  entityManager.createQuery("SELECT g FROM Genre g",Genre.class).getResultList();

    }
}
