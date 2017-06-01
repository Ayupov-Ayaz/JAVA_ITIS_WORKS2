package ru.itis.dao;

import org.hibernate.Session;
import ru.itis.hibernate.HibernateConnector;
import ru.itis.models.Film;

import java.util.List;

/**
 * 01.06.2017
 * FilmsDaoHibernate
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public class FilmsDaoHibernate  implements FilmsDao{

    private Session session;

    public FilmsDaoHibernate() {
    }


    @Override
    public Film find(int id) {
      this.session = HibernateConnector.getConnector().getSession();
      session.beginTransaction();

      Film film = (Film) session.createQuery("from Film film where id = :id", Film.class)
              .setParameter("id",id);
      session.getTransaction().commit();
      session.close();
      return film;
    }

    @Override
    public int save(Film model) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        int id = (int) session.save(model);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public void update(Film model) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        Film film = session.get(Film.class,id);
        session.delete(film);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Film> findAll() {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        List<Film> result = session.createQuery("from Film",Film.class).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Film> findByName(String name) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        List<Film> result = session.createQuery("from Film film where name = :name").setParameter("name",name).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Film> findByCountry(String country) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        List<Film> result = session.createQuery("from Film film where country = :country")
                .setParameter("country",country)
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
                .setParameter("producer",producer).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Film> findByGenre(String genre) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        List<Film> result = session.createQuery("from Film film where genre = :genre")
                .setParameter("genre",genre).list();
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
