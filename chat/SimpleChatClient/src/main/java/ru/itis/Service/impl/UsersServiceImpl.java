package ru.itis.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.Service.UsersService;
import ru.itis.dao.UsersDao;

/**
 * 29.06.2017
 * UsersServiceImpl
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    public UsersServiceImpl() {
    }

    @Override
    public String registration(String login, String password, String name, int age) {
        return usersDao.registration(login,password,name,age);
    }

    @Override
    public String login(String login, String password) {
        return usersDao.login(login,password);
    }
}
