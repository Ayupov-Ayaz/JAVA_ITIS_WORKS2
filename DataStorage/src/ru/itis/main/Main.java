package ru.itis.main;

import ru.itis.main.dao.*;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;

public class Main {

    public static void main(String[] args) {


        AppContext<User> appContext = new AppContext<>();
        AutoDao autoDao = appContext.getComponent(AutoDao.class);
        User user = new User(7,"Ayaz","qwertyu","Аяз",25);
        UsersDao usersDao = appContext.getComponent(UsersDao.class);
        Auto auto = new Auto("Toyoto","Red",147.2,true, user);

        System.out.println( autoDao.findAllAutoByOwner(user));




    }
}
