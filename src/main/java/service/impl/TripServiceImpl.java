package service.impl;

import dao.impl.TripDaoImpl;
import model.Trip;
import service.TripService;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripServiceImpl implements TripService {

    @Override
    public void getById(long id) {

    }

    @Override
    public void getAll() {

    }

    @Override
    public Set<Trip> get(int offset, int perPage, String sort) {
        return null;
    }

    @Override
    public void save(Trip trip) {

    }

    @Override
    public void update(long id, Trip trip) {

    }

    @Override
    public void delete(long tripId) {

    }

    @Override
    public List<Trip> getTripsFrom(String city) {
        return null;
    }

    @Override
    public List<Trip> getTripsTo(String city) {
        return null;
    }
}
