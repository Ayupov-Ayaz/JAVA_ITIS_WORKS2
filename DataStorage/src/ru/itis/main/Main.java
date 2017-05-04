package ru.itis.main;

import ru.itis.main.context.AppContext;
import ru.itis.main.dao.AutoDao;
import ru.itis.main.dao.UsersDao;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;
import ru.itis.main.services.DbServiceImpl;
import ru.itis.main.services.UsersService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        User roman = new User(7,"rororomama","qwer","Роман",19);
        Auto auto = new Auto(12,"Cherry","red",245.3,true,roman);
        AppContext appContext = new AppContext();
        AutoDao autoDao = (AutoDao)appContext.getComponent(AutoDao.class);
        UsersDao usersDao = (UsersDao) appContext.getComponent(UsersDao.class);
        autoDao.update(auto);


    }
}
