package service.impl;

import dao.impl.TripDaoImpl;
import model.Company;
import model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import service.TripService;

import java.util.List;


public class TripServiceImpl implements TripService {


    private final TripDaoImpl tripDao = new TripDaoImpl();


    @Override
    public void save(Trip trip) {

        tripDao.createTrip(trip);
    }

    @Override
    public Trip getById(long id) {
        Trip tripById = tripDao.getTripById(id);
        System.out.println(tripById);
        return tripById;
    }

    @Override
    public void update(Long id, Trip trip) {
        tripDao.update(id, trip);
    }

    @Override
    public void delete(long id) {
        tripDao.deleteById(id);
    }

    @Override
    public List<Trip> getAll() {
        return tripDao.getAll();
    }

    @Override
    public List<Trip> get(int offset, int perPage, String sort) {
        return tripDao.get(offset, perPage, sort);
    }


    @Override
    public List<Trip> getTripsFrom(String city) {
        return tripDao.getTripsFrom(city);
    }

    @Override
    public List<Trip> getTripsTo(String city) {
        return tripDao.getTripsTo(city);
    }


}
