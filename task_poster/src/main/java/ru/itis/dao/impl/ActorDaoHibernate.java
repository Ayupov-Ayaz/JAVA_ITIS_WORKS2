package ru.itis.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import ru.itis.dao.ActorsDao;
import ru.itis.models.Actor;
import ru.itis.models.Film;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

/**
 * 12.06.2017
 * ActorDaoHibernate @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */
@Repository
public class ActorDaoHibernate implements ActorsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Actor find(int id) {
        return null;
    }

    @Override
    public int save(Actor model) {
        entityManager.persist(model);
        entityManager.flush();
        return model.getId();
    }

    @Override
    public void update(Actor model) {
        entityManager.merge(model);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Actor> findAll() {
        return entityManager.createQuery("SELECT a FROM Actor a",Actor.class).getResultList();
    }

    @Override
    public Set<Film> findFilmByActor(String actorName) {
        Actor oneActor = entityManager.createQuery("SELECT a FROM Actor a WHERE actor_name = :actor",Actor.class)
                .setParameter("actor",actorName).getSingleResult();
        return oneActor.getFilms();
    }

    @Override
    public int getIdActorByName(String actor) {
        try {
            Actor founded = entityManager.createQuery("SELECT a FROM Actor a WHERE actor_name = :actor", Actor.class)
                    .setParameter("actor", actor).getSingleResult();
            return founded.getId();
        }catch (EmptyResultDataAccessException e){
            return -1;
        }
    }


}
