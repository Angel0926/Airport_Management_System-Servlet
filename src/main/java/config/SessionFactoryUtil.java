package config;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
    private static final Configuration configuration = new Configuration();
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
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
}
