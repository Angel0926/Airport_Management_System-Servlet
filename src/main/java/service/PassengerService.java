package service;

import model.PassInTrip;
import model.Passenger;

import java.util.List;
import java.util.Set;

public interface PassengerService {

    void getById(long id);

    void getAll();

    Set<Passenger> get(int offset, int perPage, String sort);

    void save(Passenger passenger);

    void update(long id, Passenger passenger);

    void delete(long passengerId);

    List<Passenger> getPassengersOfTrip(long tripNumber);

    void registerTrip(PassInTrip passInTrip);

    void cancelTrip(long passengerId, long tripNumber);
}
