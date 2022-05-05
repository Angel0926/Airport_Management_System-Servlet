package service.impl;

import dao.impl.PassInTripDaoImpl;
import dao.impl.PassengerDaoImpl;
import model.PassInTrip;
import model.Passenger;
import model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import service.PassengerService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PassengerServiceImpl implements PassengerService {

    private SessionFactory sessionFactory;
    private PassengerDaoImpl passengerDao;
    private PassInTripDaoImpl passInTripDao;
    private Trip trip;

    public PassengerServiceImpl(SessionFactory sessionFactory,
                                PassengerDaoImpl passengerDao,
                                PassInTripDaoImpl passInTripDao, Trip trip) {
        this.sessionFactory = sessionFactory;
        this.passengerDao = passengerDao;
        this.passInTripDao = passInTripDao;
        this.trip = trip;
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
    public void get(int offset, int perPage, String sort) {
        passengerDao.get(offset, perPage, sort);
    }


    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Passenger> passengers = null;
        Query query = session.createQuery("Select p from Passenger p join PassInTrip pit on p.id=pit.psgId   " +
                " WHERE pit.tripId = :TRIPID").setParameter("TRIPID",tripNumber);

        passengers=query.getResultList();

        return passengers;

    }


    @Override
    public void cancelTrip(long passengerId, long tripNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from PassInTrip  where psgId=:ID and tripId=:TID").
                setParameter("ID", passengerId).setParameter("TID", tripNumber);
        query.executeUpdate();
        session.close();

    }


}
