package dao;

import model.Passenger;

import java.util.List;

public interface PassengerDao {

    void createPassenger(Passenger passenger);

    List<Passenger> get(int offset, int perPage, String sort);

    void deleteById(long id);
    Passenger getPassengerById(long id);

    void update(long id, Passenger passenger);

    List<Passenger> getAll();
}
