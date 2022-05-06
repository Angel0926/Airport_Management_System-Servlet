
import dao.impl.*;
import model.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import resource.IOimpl.*;
import service.impl.CompanyServiceImpl;
import service.impl.PassengerServiceImpl;
import service.impl.TripServiceImpl;



public class AMSH_app {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Passenger.class);
        configuration.addAnnotatedClass(Trip.class);
        configuration.addAnnotatedClass(PassInTrip.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

Trip trip=new Trip();
        AddressDaoImpl addressDao = new AddressDaoImpl(sessionFactory);
        CompanyDaoImpl companyDao = new CompanyDaoImpl(sessionFactory);
        PassengerDaoImpl passengerDao = new PassengerDaoImpl(sessionFactory);
        TripDaoImpl tripDao = new TripDaoImpl(sessionFactory);
        PassInTripDaoImpl passInTripDao = new PassInTripDaoImpl(sessionFactory);

        CompanyServiceImpl companyService = new CompanyServiceImpl(sessionFactory, companyDao);
        PassengerServiceImpl passengerService = new PassengerServiceImpl(sessionFactory, passengerDao, passInTripDao,trip);
        TripServiceImpl tripService = new TripServiceImpl(sessionFactory, tripDao);

        AddressIOServiceImpl addressIOService = new AddressIOServiceImpl(sessionFactory);
        //      addressIOService.createAddressFromFile();
        PassengerIOServiceImpl passengerIOService = new PassengerIOServiceImpl(sessionFactory, addressIOService, passengerDao);
        // passengerIOService.createPassengerFromFile();
        CompanyIOServiceImpl companyIOService = new CompanyIOServiceImpl(sessionFactory);
        //companyIOService.createCompanyFromFile();
        TripIOServiceImpl tripIOService = new TripIOServiceImpl(sessionFactory, companyDao);
        //tripIOService.createPassengerFromFile();
        PassInTripIOServiceImpl passInTripIOService = new PassInTripIOServiceImpl(sessionFactory);
        //passInTripIOService.createPassInTripFromFile();


        //System.out.println(addressDao.getAddressById(3));
        // companyService.getById(3);
        // passengerService.getById(3);
        // tripService.getById(1124);

        //addressDao.deleteById(4);
        //companyService.delete(12);
        //passengerService.delete(4);
        //tripService.delete(1100);


        // addressDao.update(5,new Address("ARMENIAN", "YEREVAN"));
        // companyService.update(2L, new Company("bbbba", LocalDate.now(Clock.systemUTC())));
        // passengerService.update(8, new Passenger("ddkd", "4561-236-584"));
        // tripService.update(1101L, new Trip("fff", "aaa", "bbb", LocalTime.of(20, 15, 0), LocalTime.of(21, 16, 0)));

        // System.out.println(addressDao.getAll());
        // System.out.println(companyDao.getAll());
        // System.out.println(passengerDao.getAll());
        // System.out.println(tripDao.getAll());


        // System.out.println(tripService.getTripsFrom("Paris"));
        // System.out.println(tripService.getTripsTo("Paris"));
        // System.out.println(passengerDao.get(4, 6, "name"));
        for (Company company: new CompanyServiceImpl(sessionFactory,companyDao).get(2, 10, "foundingDate")){
            System.out.println(company);
        }
//        System.out.println(companyService.get(2, 3, "founding_date"));
        // System.out.println(tripService.get(2, 3, "plane"));


     //passengerService.cancelTrip(3,1145);
      //  System.out.println(passengerService.getPassengersOfTrip(1145));
    }
}
