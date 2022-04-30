
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import resource.IOimpl.*;
import service.impl.CompanyServiceImpl;

import java.time.LocalDate;


public class AMS_app {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();

//        configuration.addAnnotatedClass(Address.class);
//        configuration.addAnnotatedClass(Company.class);
//        configuration.addAnnotatedClass(Passenger.class);
//        configuration.addAnnotatedClass(Trip.class);
//        configuration.addAnnotatedClass(PassInTrip.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        Company company = new Company("ssssdgd", LocalDate.now());
//        companyDao.save(company, sessionFactory);
//        AddressIOServiceImpl.createAddressFromFile(sessionFactory);
//
//        PassengerIOServiceImpl.createPassengerFromFile(sessionFactory);
//
//        CompanyIOServiceImpl.createCompanyFromFile(sessionFactory);
//
//        TripIOServiceImpl.createPassengerFromFile(sessionFactory);
//
//        PassInTripIOServiceImpl.createPassInTripFromFile(sessionFactory);




}}
