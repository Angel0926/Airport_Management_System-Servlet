package service;

import model.Trip;

import java.util.List;
import java.util.Set;

public interface TripService {
    void getById(long id);

    void getAll();

    Set<Trip> get(int offset, int perPage, String sort);

    void save(Trip trip);

    void update(long id, Trip trip);

    void delete(long tripId);

    List<Trip> getTripsFrom(String city);

    List<Trip> getTripsTo(String city);
}
