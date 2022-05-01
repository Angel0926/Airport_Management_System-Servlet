package dao.impl;

import dao.TripDao;

import model.Passenger;
import model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;


public class TripDaoImpl implements TripDao {
    @Override
    public void createTrip(Trip trip, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(trip);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Trip getTripById(long id,SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Trip trip = null;
        try {

            trip= session.get(Trip.class, id);

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {

              try {if(session != null) session.close();} catch(Exception ex) {}
        }
        return trip;
    }

    @Override
    public void deleteById(long id,SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
       Trip trip = null;
        trip=getTripById(id,sessionFactory);
        session.delete(trip);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void update(long id, Trip trip) {

    }





    @Override
    public Set<Trip> getAll() {
    return  null;}
}
