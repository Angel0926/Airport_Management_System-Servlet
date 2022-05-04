package service;

import model.PassInTrip;
import model.Passenger;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

public interface PassengerService {



    void getById(long id);

    void delete(long id);

    public void save(Passenger passenger);

    void update(long id, Passenger passenger);

    void getAll();

    Set<Passenger> get(int offset, int perPage, String sort);


    List<Passenger> getPassengersOfTrip(long tripNumber);


    void registerTrip(PassInTrip passInTrip);

    void cancelTrip(long passengerId, long tripNumber);
}
