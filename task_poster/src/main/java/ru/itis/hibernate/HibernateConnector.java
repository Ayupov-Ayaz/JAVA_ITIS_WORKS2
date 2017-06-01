package ru.itis.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.itis.models.Actor;
import ru.itis.models.Genre;


/**
 * 01.06.2017
 * HibernateConnector
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public class HibernateConnector {
    private static HibernateConnector connector;
    private Configuration configuration;
    private SessionFactory sessionFactory;

    private HibernateConnector(){
        configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/itis");
        configuration.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password","aspirin12");
        configuration.setProperty("hibernate.connection.show_sql","true");
        configuration.setProperty("hibernate.dialect","rg.hibernate.dialect.PostgreSQLDialect");
        //что нужно сделать с таблицей при инициализации
        configuration.setProperty("hibernate.hbm2ddl.auto","update");

        configuration.addResource("hibernate\\Actor.hbm.xml");
        configuration.addResource("hibernate\\Genre.hbm.xml");
        // зависимые таблицы
        configuration.addAnnotatedClass(Actor.class);
        configuration.addAnnotatedClass(Genre.class);

        sessionFactory = configuration.buildSessionFactory();
    }
    static{
        connector = new HibernateConnector();
    }

    public static HibernateConnector getConnector() {
        return connector;
    }
    public Session getSession(){
        Session session = sessionFactory.openSession();
        if(!session.isConnected()){
            this.reconect();
        }
        return session;
    }
    private void reconect(){
        this.sessionFactory = configuration.buildSessionFactory();
    }
}
