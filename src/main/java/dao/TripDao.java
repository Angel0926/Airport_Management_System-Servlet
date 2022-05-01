package dao;

import model.Trip;
import org.hibernate.SessionFactory;

import java.util.Set;

public interface TripDao {

    void createTrip(Trip trip, SessionFactory sessionFactory);

    void deleteById(long id, SessionFactory sessionFactory);

    void update(long id, Trip trip);


    Trip getTripById(long id, SessionFactory sessionFactory);

    Set<Trip> getAll();
}
