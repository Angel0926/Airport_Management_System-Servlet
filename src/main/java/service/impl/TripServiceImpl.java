package service.impl;

import dao.impl.TripDaoImpl;
import model.Trip;
import org.hibernate.SessionFactory;
import service.TripService;

import java.util.List;
import java.util.Set;


public class TripServiceImpl implements TripService {
  TripDaoImpl tripDao=new TripDaoImpl();
    @Override
    public void save(Trip trip, SessionFactory sessionFactory){
        tripDao.createTrip(trip,sessionFactory);
    }

    @Override
    public void getById(long id) {

    }

    @Override
    public void getAll() {

    }

    @Override
    public Set<Trip> get(int offset, int perPage, String sort) {
        return null;
    }




@Override
    public void update(Long id, Trip trip, SessionFactory sessionFactory) {
tripDao.update(id,trip);
    }

    @Override
    public void delete(long tripId) {

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
