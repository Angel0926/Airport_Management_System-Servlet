package service;

import model.Trip;

import java.util.List;

public interface TripService {
    void save(Trip trip);


    Trip getById(long id);

    List<Trip> getAll();

    List<Trip> get(int offset, int perPage, String sort);


    void update(Long id, Trip trip);

    void delete(long tripId);

    List<Trip> getTripsFrom(String city);

    List<Trip> getTripsTo(String city);
}
