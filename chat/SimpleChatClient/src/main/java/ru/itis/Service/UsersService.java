package ru.itis.Service;

/**
 * 29.06.2017
 * UsersService
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersService {
    String registration(String login, String password, String name, int age);
    String login(String login, String password);
}
