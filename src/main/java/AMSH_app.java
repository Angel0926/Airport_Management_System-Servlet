
import dao.impl.AddressDaoImpl;
import model.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import resource.IOimpl.CompanyIOServiceImpl;
import resource.IOimpl.PassInTripIOServiceImpl;
import resource.IOimpl.PassengerIOServiceImpl;
import resource.IOimpl.TripIOServiceImpl;
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


        AddressDaoImpl addressDao = new AddressDaoImpl();
        CompanyServiceImpl companyService = new CompanyServiceImpl(sessionFactory);
        PassengerServiceImpl passengerService = new PassengerServiceImpl(sessionFactory);
        TripServiceImpl tripService = new TripServiceImpl(sessionFactory);




//        Company company = new Company("ssssdgd", LocalDate.now());
//        companyDao.save(company, sessionFactory);
//
//        AddressIOServiceImpl.input(AddressIOServiceImpl.createAddressFromFile(sessionFactory),sessionFactory);
        PassengerIOServiceImpl passengerIOService=new PassengerIOServiceImpl(sessionFactory);
        passengerIOService.createPassengerFromFile();
        CompanyIOServiceImpl companyIOService=new CompanyIOServiceImpl(sessionFactory);
        companyIOService.createCompanyFromFile();
        TripIOServiceImpl tripIOService=new TripIOServiceImpl(sessionFactory);
        tripIOService.createPassengerFromFile();
        PassInTripIOServiceImpl passInTripIOService=new PassInTripIOServiceImpl(sessionFactory);
       passInTripIOService.createPassInTripFromFile();



//    System.out.println(addressDao.getAddressById(3, sessionFactory));
     // companyService.getById(3, sessionFactory);
 // passengerService.getById(3, sessionFactory);

//        tripService.getById(1124, sessionFactory);

    //     addressDao.deleteById(5, sessionFactory);
//companyService.delete(7,sessionFactory);
        //     passengerService.delete(3,sessionFactory);
//tripService.delete(1100,sessionFactory);


        //    addressDao.update(2,sessionFactory,new Address("ARMENIA", "YEREVAN"));
      //   companyService.update(2L, sessionFactory, new Company("bbbba", LocalDate.now(Clock.systemUTC())));
        //      passengerService.update(2, new Passenger("ddd", "451-236-584"), sessionFactory);
       // tripService.update(1101L, new Trip("fff", "aaa", "bbb", LocalTime.of(20, 15, 0), LocalTime.of(21, 16, 0)), sessionFactory);

       // System.out.println(addressDao.getAll());
    }
}
