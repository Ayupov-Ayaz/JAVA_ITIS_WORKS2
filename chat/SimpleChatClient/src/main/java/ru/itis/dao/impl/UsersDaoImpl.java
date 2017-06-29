package ru.itis.dao.impl;

import org.springframework.stereotype.Repository;
import ru.itis.dao.UsersDao;
import ru.itis.models.UserDataForRegistrationDto;

/**
 * 29.06.2017
 * UsersDaoImpl
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Repository
public class UsersDaoImpl implements UsersDao {

    public UsersDaoImpl() {
    }

    @Override
    public String registration(String login, String password, String name, int age) {
        UserDataForRegistrationDto user = new UserDataForRegistrationDto(login,password,age,name);
        return null;
        //TODO: Отправить через Body
    }

    @Override
    public String login(String login, String password) {
        return null;
        //TODO: отправить через Header
    }
}
