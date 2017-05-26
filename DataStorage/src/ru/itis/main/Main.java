package ru.itis.main;

import ru.itis.main.context.AppContext;
import ru.itis.main.dao.*;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;
<<<<<<< HEAD
=======
import ru.itis.main.services.UsersService;
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191
//import ru.itis.main.models.User.Builder;

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
        AppContext<User> appContext = new AppContext<>();
        UsersDao usersDao = appContext.getComponent(UsersDao.class);
        User myrad = new User.Builder().id(3).login("Vika").password("vikula").name("Виктория").age(22).build();
        System.out.println(usersDao.findAllByName("Виктория"));




=======
        AppContext<Auto> appContext = new AppContext<>();
        AppContext<User> appContext1 = new AppContext<>();
        UsersDao usersDao = appContext1.getComponent(UsersDao.class);
        AutoDao autoDao = appContext.getComponent(AutoDao.class);
        UsersService usersService = appContext1.getComponent(UsersService.class);
        User user = usersDao.find(2);
        System.out.println(autoDao.findAllAutoByOwner(user));
        System.out.println(usersService.isRegistered(user.getName()));
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191


    }
}
