package service.impl;

import dao.impl.TripDaoImpl;
import model.Trip;
import service.DatabaseConnectionService;
import service.TripService;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripServiceImpl implements TripService {
    TripDaoImpl tripDao = new TripDaoImpl();

    @Override
    public void getById(long id) {
        tripDao.getTripById(id);
    }

    @Override
    public void getAll() {
        tripDao.getAll();
    }

    @Override
    public Set<Trip> get(int offset, int perPage, String sort) {
        /* SELECT *
        from trip
        order by plane
        LIMIT 5 OFFSET 10*/

        Set<Trip> tripes = null;
        try (Connection connection = DatabaseConnectionService
                .DB_INSTANCE.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet =
                     statement.executeQuery(
                             "SELECT * FROM trip " +
                                     "order by " + sort + " limit " + perPage +
                                     " OFFSET " + offset + ";")) {

            tripes = new HashSet<>();
            Trip trip;
            while (resultSet.next()) {
                trip= new Trip(
                        resultSet.getLong("comp_id"),
                        resultSet.getString("plane"),
                        resultSet.getString("town_from"),
                        resultSet.getString("town_to"),
                        LocalTime.parse(resultSet.getTime("time_out").toString()),
                        LocalTime.parse(resultSet.getTime("time_in").toString())
                );
                tripes.add(trip);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tripes;
    }


    @Override
    public void save(Trip trip) {
        tripDao.createTrip(trip);
    }

    @Override
    public void update(long id, Trip trip) {
        tripDao.update(id, trip);
    }

    @Override
    public void delete(long tripId) {
        tripDao.deleteById(tripId);
    }

    @Override
    public List<Trip> getTripsFrom(String city) {
      /* SELECT *
from trip
where town_from= 'Paris'*/
        List<Trip> tripes = null;
        try (Connection connection = DatabaseConnectionService
                .DB_INSTANCE.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet =
                     statement.executeQuery(
                             "SELECT * FROM trip " +
                                     "WHERE town_from = '" + city + "'")) {

            tripes = new ArrayList<>();
            Trip trip;
            while (resultSet.next()) {
                trip= new Trip(
                        resultSet.getLong("comp_id"),
                        resultSet.getString("plane"),
                        resultSet.getString("town_from"),
                        resultSet.getString("town_to"),
                        LocalTime.parse(resultSet.getTime("time_out").toString()),
                        LocalTime.parse(resultSet.getTime("time_in").toString())
                );
                tripes.add(trip);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tripes;
    }

    @Override
    public List<Trip> getTripsTo(String city) {
        /* SELECT *
from trip
where town_to= 'Paris'*/
        List<Trip> tripes = null;
        try (Connection connection = DatabaseConnectionService
                .DB_INSTANCE.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet =
                     statement.executeQuery(
                             "SELECT * FROM trip " +
                                     "WHERE town_to = '" + city + "'")) {

            tripes = new ArrayList<>();
            Trip trip;
            while (resultSet.next()) {
                trip= new Trip(
                        resultSet.getLong("comp_id"),
                        resultSet.getString("plane"),
                        resultSet.getString("town_from"),
                        resultSet.getString("town_to"),
                        LocalTime.parse(resultSet.getTime("time_out").toString()),
                        LocalTime.parse(resultSet.getTime("time_in").toString())
                );
                tripes.add(trip);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tripes;
    }
}
