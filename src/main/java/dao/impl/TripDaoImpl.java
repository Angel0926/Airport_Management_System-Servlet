package dao.impl;

import dao.TripDao;

import model.Passenger;
import model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;


public class TripDaoImpl implements TripDao {
    private  SessionFactory sessionFactory;

    public TripDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createTrip(Trip trip) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(trip);
        session.getTransaction().commit();
        session.close();
    }


    public Trip getTripById(long id) {
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


    public void deleteById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
       Trip trip = null;
        trip=getTripById(id);
        session.delete(trip);
        session.getTransaction().commit();
        session.close();
    }

    public void update(long id, Trip trip) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
       Trip old = getTripById(id);
        old.setPlane(trip.getPlane());
        old.setTownFrom(trip.getTownFrom());
        old.setTownTo(trip.getTownTo());
        old.setTimeIn(trip.getTimeIn());
        old.setTimeOut(trip.getTimeOut());
        session.update(old);
        session.getTransaction().commit();
        sessionFactory.close();
    }


    @Override
    public Set<Trip> getAll() {
    return  null;}
}
