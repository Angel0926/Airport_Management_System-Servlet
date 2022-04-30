package dao;

import model.PassInTrip;
import model.Passenger;
import org.hibernate.SessionFactory;

public interface PassInTripDao {
    void createPassInTrip(PassInTrip passInTrip, SessionFactory sessionFactory);
}
