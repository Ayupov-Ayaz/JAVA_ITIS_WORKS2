package ru.itis.dao;

/**
 * 29.06.2017
 * UsersDao
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersDao {
    String registration(String login, String password, String name, int age);
    String login(String login, String password);
}
