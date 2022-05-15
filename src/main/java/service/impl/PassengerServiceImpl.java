package service.impl;

import dao.impl.PassInTripDaoImpl;
import dao.impl.PassengerDaoImpl;
import model.PassInTrip;
import model.Passenger;
import service.PassengerService;

import java.util.List;


public class PassengerServiceImpl implements PassengerService {

    private final PassengerDaoImpl passengerDao = new PassengerDaoImpl();
    private final PassInTripDaoImpl passInTripDao = new PassInTripDaoImpl();


    @Override
    public void save(Passenger passenger) {
        passengerDao.createPassenger(passenger);
    }


    @Override
    public Passenger getById(long id) {
        Passenger passengerById = passengerDao.getPassengerById(id);
        System.out.println(passengerById);
        return passengerById;
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
    public List<Passenger> getAll() {
        return passengerDao.getAll();
    }

    @Override
    public List<Passenger> get(int offset, int perPage, String sort) {
        return passengerDao.get(offset, perPage, sort);
    }


    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
       return passengerDao.getPassengerOfTrip(tripNumber);

    }


    @Override
    public void cancelTrip(long passengerId, long tripNumber) {
        passengerDao.cancelTrip(passengerId,tripNumber);

    }


}
