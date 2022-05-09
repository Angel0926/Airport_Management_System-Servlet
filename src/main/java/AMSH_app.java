
import dao.impl.*;
import model.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import resource.IOimpl.*;
import service.impl.CompanyServiceImpl;
import service.impl.PassengerServiceImpl;
import service.impl.TripServiceImpl;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;


public class AMSH_app {

    private static final CompanyServiceImpl companyService = new CompanyServiceImpl();
    private static final PassengerServiceImpl passengerService = new PassengerServiceImpl();
    private static final TripServiceImpl tripService = new TripServiceImpl();
    private static final AddressDaoImpl addressDao = new AddressDaoImpl();

    private static final AddressIOServiceImpl addressIOService = new AddressIOServiceImpl();
    private static final PassengerIOServiceImpl passengerIOService = new PassengerIOServiceImpl();
    private static final CompanyIOServiceImpl companyIOService = new CompanyIOServiceImpl();
    private static final TripIOServiceImpl tripIOService = new TripIOServiceImpl();
    private static final PassInTripIOServiceImpl passInTripIOService = new PassInTripIOServiceImpl();

    public static void main(String[] args) {

//
//        addressIOService.createAddressFromFile();

        passengerIOService.createPassengerFromFile();

        companyIOService.createCompanyFromFile();

        tripIOService.createPassengerFromFile();

        passInTripIOService.createPassInTripFromFile();

//
//        System.out.println(addressDao.getAddressById(3));
//        companyService.getById(3);
//        passengerService.getById(3);
//        tripService.getById(1124);
//
//        addressDao.deleteById(4);
//        companyService.delete(12);
//        passengerService.delete(4);
//        tripService.delete(1100);
//
//
//        addressDao.update(5, new Address("ARMENIAN", "YEREVAN"));
//        companyService.update(2L, new Company("bbbba", LocalDate.now(Clock.systemUTC())));
//        passengerService.update(8, new Passenger("ddkd", "4561-236-584"));
//        tripService.update(1101L, new Trip("fff", "aaa", "bbb", LocalTime.of(20, 15, 0), LocalTime.of(21, 16, 0)));
//
//        System.out.println(addressDao.getAll());
//        System.out.println(companyService.getAll());
//        System.out.println(passengerService.getAll());
//        System.out.println(tripService.getAll());
//
//
//        System.out.println(tripService.getTripsFrom("Paris"));
//        System.out.println(tripService.getTripsTo("Paris"));
//        System.out.println(passengerService.get(4, 6, "name"));
//
//        System.out.println(companyService.get(2, 3, "founding_date"));
//        System.out.println(tripService.get(2, 3, "plane"));
//
//
//        passengerService.cancelTrip(3, 1145);
//        System.out.println(passengerService.getPassengersOfTrip(1145));
    }
}
