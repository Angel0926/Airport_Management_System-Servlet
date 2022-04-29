

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.impl.CompanyIOImpl;

import java.time.LocalDate;


public class AMS_app {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Passenger.class);
        configuration.addAnnotatedClass(Trip.class);
//      configuration.addAnnotatedClass(PassInTrip.class);
//


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Company company=new Company("fdsvdf", LocalDate.now());
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();
        CompanyIOImpl.getCompanyFromFile();
    }
}