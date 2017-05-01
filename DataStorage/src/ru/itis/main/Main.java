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

        User kamil = new User("Kanzler","kanz56","Камилька",23);
        User kamil2 = new User(18,"Kanzler123","kanz233356","Роман0",23);
        AppContext<User> appContext = new AppContext<>();
        UsersService usersService = appContext.getComponent(UsersService.class);
        Auto auto = new Auto("cherry","red",847.2,true);
        IdGenerator idGenerator = new SimpleIdGenerator("id.txt");
        FileDaoQueryTemplate fileDaoQueryTemplate = new FileDaoQueryTemplateImpl(idGenerator);
        AutoDao autoDao = new AutoDaoFileBasedImpl("auto.txt",fileDaoQueryTemplate);




    }
}
