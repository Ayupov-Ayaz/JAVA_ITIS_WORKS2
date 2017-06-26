package ru.itis.services;

import ru.itis.dto.UserDataForRegistrationDto;
import ru.itis.dto.UserDto;
import ru.itis.models.User;

import java.util.List;

/**
 * 26.06.2017
 * Service class for {@link ru.itis.models.User}
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersService {

    UserDto registerUSer (UserDataForRegistrationDto user);

    String login(String password, String login);

    List<User> getUsers();
}
