package service.impl;

import dao.impl.TripDaoImpl;
import model.Trip;
import service.TripService;

import java.util.List;
import java.util.Set;

public class TripServiceImpl implements TripService {
    TripDaoImpl tripDao = new TripDaoImpl();

    @Override
    public void getById(long id) {
        tripDao.getTripById(id);
    }

    @Override
    public void getAll() {
        tripDao.getAll();
    }

    @Override
    public Set<Trip> get(int offset, int perPage, String sort) {
        return null;
    }

    @Override
    public void save(Trip trip) {
        tripDao.createTrip(trip);
    }

    @Override
    public void update(long id, Trip trip) {
        tripDao.update(id, trip);
    }

    @Override
    public void delete(long tripId) {
        tripDao.deleteById(tripId);
    }

    @Override
    public List<Trip> getTripsFrom(String city) {
        return null;
    }

    @Override
    public List<Trip> getTripsTo(String city) {
        return null;
    }
}
