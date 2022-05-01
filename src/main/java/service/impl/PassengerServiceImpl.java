package service.impl;

import dao.impl.PassInTripDaoImpl;
import dao.impl.PassengerDaoImpl;
import model.PassInTrip;
import model.Passenger;
import org.hibernate.SessionFactory;
import service.PassengerService;

import java.util.List;
import java.util.Set;


public class PassengerServiceImpl implements PassengerService {
    PassengerDaoImpl passengerDao = new PassengerDaoImpl();
    PassInTripDaoImpl passInTripDao=new PassInTripDaoImpl();
    @Override
    public void save(Passenger passenger, SessionFactory sessionFactory) {
        passengerDao.createPassenger(passenger, sessionFactory);


    }
    @Override
    public void getById(long id) {

    }

    @Override
    public void getAll() {

    }

    @Override
    public Set<Passenger> get(int offset, int perPage, String sort) {
        return null;
    }



    @Override
    public void update(long id, Passenger passenger) {

    }


    public void delete(long companyId) {

    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return null;
    }

    @Override
    public void registerTrip(PassInTrip passInTrip, SessionFactory sessionFactory) {
       passInTripDao.createPassInTrip(passInTrip,sessionFactory);
    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }


}
