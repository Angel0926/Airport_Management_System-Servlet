package dao;

import model.Passenger;
import org.hibernate.SessionFactory;

import java.util.Set;

public interface PassengerDao {

    void createPassenger(Passenger passenger, SessionFactory sessionFactory);

    void deleteById(long id, SessionFactory sessionFactory);

    void update(long id, Passenger passenger);




    Passenger getPassengerById(long id, SessionFactory sessionFactory);

    Set<Passenger> getAll();
}
