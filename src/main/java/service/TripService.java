package service;

import model.Company;
import model.Passenger;
import model.Trip;
import org.hibernate.SessionFactory;

import javax.swing.table.TableRowSorter;
import java.util.List;
import java.util.Set;

public interface TripService {
    void save(Trip trip);


    void getById(long id);

    void getAll();

    Set<Trip> get(int offset, int perPage, String sort);


    void update(Long id, Trip trip);

    void delete(long tripId);

    List<Trip> getTripsFrom(String city);

    List<Trip> getTripsTo(String city);
}
