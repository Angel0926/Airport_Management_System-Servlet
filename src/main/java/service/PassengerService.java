package service;

import model.PassInTrip;
import model.Passenger;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

public interface PassengerService {


    void getById(long id, SessionFactory sessionFactory);

    void delete(long id, SessionFactory sessionFactory);

    public void save(Passenger passenger, SessionFactory sessionFactory);

    void update(long id, Passenger passenger, SessionFactory sessionFactory);

    void getAll();

    Set<Passenger> get(int offset, int perPage, String sort);


    List<Passenger> getPassengersOfTrip(long tripNumber);


    void registerTrip(PassInTrip passInTrip, SessionFactory sessionFactory);

    void cancelTrip(long passengerId, long tripNumber);
}
