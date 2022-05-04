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

    private  SessionFactory sessionFactory;
    private PassengerDaoImpl passengerDao;
    private PassInTripDaoImpl passInTripDao;

    public PassengerServiceImpl(SessionFactory sessionFactory, PassengerDaoImpl passengerDao, PassInTripDaoImpl passInTripDao) {
        this.sessionFactory = sessionFactory;
        this.passengerDao = passengerDao;
        this.passInTripDao = passInTripDao;
    }

    @Override
    public void save(Passenger passenger) {
        passengerDao.createPassenger(passenger);
    }


    @Override
    public void getById(long id) {
        System.out.println(passengerDao.getPassengerById(id));
    }

    @Override
    public void delete(long id) {
        passengerDao.deleteById(id);
    }

    @Override
    public void update(long id, Passenger passenger) {
        passengerDao.update(id, passenger);
    }
    @Override
    public void registerTrip(PassInTrip passInTrip) {
        passInTripDao.createPassInTrip(passInTrip);
    }

    @Override
    public void getAll() {
        passengerDao.getAll();
    }
    @Override
    public Set<Passenger> get(int offset, int perPage, String sort) {
        return null;
    }


    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return null;
    }



    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }


}
