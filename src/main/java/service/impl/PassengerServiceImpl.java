package service.impl;

import dao.impl.PassInTripDaoImpl;
import dao.impl.PassengerDaoImpl;
import model.PassInTrip;
import model.Passenger;
import service.PassengerService;

import java.sql.*;
import java.util.*;


public class PassengerServiceImpl implements PassengerService {
    PassengerDaoImpl passengerDao = new PassengerDaoImpl();
    PassInTripDaoImpl passInTripDao = new PassInTripDaoImpl();

    @Override
    public void getById(long id) {

        passengerDao.getPassengerById(id);
    }

    @Override
    public void getAll() {
        passengerDao.getAll();
    }

    @Override
    public Set<Passenger> get(int offset, int perPage, String sort) {
    return  null;
    }


    @Override
    public void save(Passenger passenger) {
        passengerDao.createPassenger(passenger);
    }

    @Override
    public void update(long id, Passenger passenger) {
        passengerDao.update(id, passenger);
    }

    @Override
    public void delete(long passengerId) {
        passengerDao.deleteById(passengerId);
    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
      return  null;
    }

    @Override
    public void registerTrip(PassInTrip passInTrip) {
        passInTripDao.createPassInTrip(passInTrip);

    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

        }
    }

