
import model.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import resource.IOimpl.*;


public class AMSH_app {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Passenger.class);
        configuration.addAnnotatedClass(Trip.class);
        configuration.addAnnotatedClass(PassInTrip.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        Company company = new Company("ssssdgd", LocalDate.now());
//        companyDao.save(company, sessionFactory);
        //AddressIOServiceImpl.createAddressFromFile(sessionFactory);

        PassengerIOServiceImpl.createPassengerFromFile(sessionFactory);

        CompanyIOServiceImpl.createCompanyFromFile(sessionFactory);

        TripIOServiceImpl.createPassengerFromFile(sessionFactory);

        PassInTripIOServiceImpl.createPassInTripFromFile(sessionFactory);

//        AddressDaoImpl addressDao=new AddressDaoImpl();
//        System.out.println(addressDao.getAddressById(3, sessionFactory));
//        CompanyServiceImpl companyService=new CompanyServiceImpl();
//companyService.deleteById(3);
    }
}
