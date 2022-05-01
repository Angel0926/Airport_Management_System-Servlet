
import dao.impl.AddressDaoImpl;

import dao.impl.TripDaoImpl;
import model.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import resource.IOimpl.*;
import service.impl.CompanyServiceImpl;
import service.impl.PassengerServiceImpl;
import service.impl.TripServiceImpl;


public class AMSH_app {

    public static void main(String[] args) {
        AddressDaoImpl addressDao = new AddressDaoImpl();
        CompanyServiceImpl companyService = new CompanyServiceImpl();
        PassengerServiceImpl passengerService = new PassengerServiceImpl();
        TripServiceImpl tripService = new TripServiceImpl();


        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Passenger.class);
        configuration.addAnnotatedClass(Trip.class);
        configuration.addAnnotatedClass(PassInTrip.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        Company company = new Company("ssssdgd", LocalDate.now());
//        companyDao.save(company, sessionFactory);

        // AddressIOServiceImpl.createAddressFromFile(sessionFactory);
        PassengerIOServiceImpl.createPassengerFromFile(sessionFactory);
        CompanyIOServiceImpl.createCompanyFromFile(sessionFactory);
        TripIOServiceImpl.createPassengerFromFile(sessionFactory);
        PassInTripIOServiceImpl.createPassInTripFromFile(sessionFactory);


//        System.out.println(addressDao.getAddressById(3, sessionFactory));
//        companyService.getById(3, sessionFactory);
//        passengerService.getById(3, sessionFactory);
//        tripService.getById(1124, sessionFactory);

     //   addressDao.deleteById(6, sessionFactory);
//companyService.delete(5,sessionFactory);
   //     passengerService.delete(3,sessionFactory);
//tripService.delete(1100,sessionFactory);
    }
}
