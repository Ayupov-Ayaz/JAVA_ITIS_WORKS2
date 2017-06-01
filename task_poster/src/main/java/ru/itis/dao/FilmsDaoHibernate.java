package ru.itis.dao;

import org.hibernate.Session;
import ru.itis.hibernate.HibernateConnector;
import ru.itis.models.Film;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * 01.06.2017
 * FilmsDaoHibernate
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public class FilmsDaoHibernate implements FilmsDao {


    @PersistenceContext
    private EntityManager entityManager;


    public FilmsDaoHibernate() {
    }


    @Override
    public Film find(int id) {

        return (Film) entityManager.createQuery("SELECT f FROM Film f join fetch f.actors join fetch f.genres where id = :id", Film.class)
                .setParameter("id", id);

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
        return (List<Film>) entityManager.createQuery("SELECT f from Film f join fetch f.actors join fetch f.genres");
    }

    @Override
    public List<Film> findByName(String name) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        List<Film> result = session.createQuery("from Film film where name = :name").setParameter("name", name).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Film> findByCountry(String country) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        List<Film> result = session.createQuery("from Film film where country = :country")
                .setParameter("country", country)
                .list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Film> findByProducer(String producer) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        List<Film> result = session.createQuery("from Film film where producer = :producer")
                .setParameter("producer", producer).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Film> findByGenre(String genre) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        List<Film> result = session.createQuery("from Film film where genre = :genre")
                .setParameter("genre", genre).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Film> findByActors(String actorsName) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        List<Film> result = session.createQuery("from Film film where actor_name = :actor_name")
                .setParameter("actor_name", actorsName).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
