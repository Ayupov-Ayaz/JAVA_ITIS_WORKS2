package ru.itis.main;

import ru.itis.main.dao.AppContext;
import ru.itis.main.dao.AutoDao;
import ru.itis.main.dao.AutoDaoFileBasedImpl;
import ru.itis.main.generators.IdGenerator;
import ru.itis.main.generators.SimpleIdGenerator;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;
import ru.itis.main.services.UsersService;
import ru.itis.main.utils.FileDaoQueryTemplate;
import ru.itis.main.utils.FileDaoQueryTemplateImpl;

public class Main {

    public static void main(String[] args) {


        AppContext<User> appContext = new AppContext<>();
        AutoDao autoDao = appContext.getComponent(AutoDao.class);
        Auto auto = new Auto(5,"Toyoto","Green",147.2,true);

        autoDao.delete(1);





    }
}
