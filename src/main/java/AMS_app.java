import dao.AddressDao;
import dao.CompanyDao;
import dao.PassengerDao;
import dao.TripDao;
import dao.impl.AddressDaoImpl;
import dao.impl.CompanyDaoImpl;
import dao.impl.PassengerDaoImpl;
import dao.impl.TripDaoImpl;
import model.PassInTrip;
import model.Trip;
import resource.IOimpl.*;
import service.impl.CompanyServiceImpl;
import service.impl.PassengerServiceImpl;
import service.impl.TripServiceImpl;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AMS_app {

    public static void main(String[] args) {
        AddressDao addressDao = new AddressDaoImpl();
        CompanyDao companyDao = new CompanyDaoImpl();
        PassengerDao passengerDao = new PassengerDaoImpl();
        TripDao tripDao = new TripDaoImpl();
        TripServiceImpl tripService=new TripServiceImpl();

PassengerServiceImpl passengerService=new PassengerServiceImpl();
passengerService.cancelTrip(3,1123);
//      passengerService.registerTrip(new PassInTrip(1188,10,LocalDate.parse(
//              "2003-04-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"3b"));
       // AddressIOimpl.getAddressFromFile();
       // PassengerIOImpl.getPassengersFromFile();
        // CompanyIOImpl.getCompanyFromFile();
         // TripIOimpl.getTripFromFile();
       // PassInTripIOImpl.getPassInTripFromFile();

    }
}