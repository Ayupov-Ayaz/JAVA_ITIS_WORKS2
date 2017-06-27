package ru.itis.dao;

import ru.itis.models.User;

import java.util.List;

/**
 * 27.06.2017
 * UsersDao
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersDao {
    User getUserByLogin(String login);
    User getUserByName(String name);
    List<User> getAll();
}
