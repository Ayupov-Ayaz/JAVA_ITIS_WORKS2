package ru.itis.services;

import ru.itis.models.User;

import java.util.List;

/**
 * 27.06.2017
 * UserService
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public interface UserService {
    User getUserByLogin(String login);
    User getUserByName(String name);
    List<User> findAll();
}
