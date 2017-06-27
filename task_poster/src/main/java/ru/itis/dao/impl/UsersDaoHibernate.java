package ru.itis.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.itis.dao.UsersDao;
import ru.itis.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * 27.06.2017
 * UsersDaoHibernate
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Repository
public class UsersDaoHibernate implements UsersDao {

    private final static String JPA_FIND_ALL = "SELECT u FROM User u ";

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User getUserByLogin(String login) {
       return entityManager.createQuery(JPA_FIND_ALL + " where login = :login", User.class)
               .setParameter("login",login).getSingleResult();
    }

    @Override
    public User getUserByName(String name) {
       return entityManager.createQuery(JPA_FIND_ALL + " where name = :name", User.class)
               .setParameter("name",name).getSingleResult();
    }

    @Override
    public List<User> getAll() {
       return entityManager.createQuery(JPA_FIND_ALL , User.class).getResultList();
    }
}
