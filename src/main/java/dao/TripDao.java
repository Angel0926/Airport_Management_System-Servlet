package dao;

import model.Trip;

import java.util.List;

public interface TripDao {

    void createTrip(Trip trip);

    void deleteById(long id);


    Trip getTripById(long id);

    void update(long id, Trip trip);

    List<Trip> getAll();
}
