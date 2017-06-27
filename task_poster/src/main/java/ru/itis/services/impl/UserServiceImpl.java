package ru.itis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dao.UsersDao;
import ru.itis.models.User;
import ru.itis.services.UserService;

import java.util.List;

/**
 * 27.06.2017
 * UserServiceImpl
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersDao usersDao;

    @Override
    public User getUserByLogin(String login) {
        return usersDao.getUserByLogin(login);
    }

    @Override
    public User getUserByName(String name) {
        return usersDao.getUserByName(name);
    }

    @Override
    public List<User> findAll() {
       return usersDao.getAll();
    }
}
