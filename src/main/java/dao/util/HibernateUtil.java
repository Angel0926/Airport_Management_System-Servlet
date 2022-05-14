package dao.util;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final HibernateUtil instance = new HibernateUtil();
    private HibernateUtil(){}
    private  SessionFactory sessionFactory = buildSessionFactory();

    private SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Passenger.class);
        configuration.addAnnotatedClass(Trip.class);
        configuration.addAnnotatedClass(PassInTrip.class);
        if (sessionFactory == null) {
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static HibernateUtil getInstance(){
        return instance;
    }


}
