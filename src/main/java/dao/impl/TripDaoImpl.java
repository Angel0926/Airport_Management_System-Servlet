package dao.impl;

import config.HibernateConfigUtil;
import dao.TripDao;

import model.Company;
import model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class TripDaoImpl implements TripDao {
    private final SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();


    @Override
    public void createTrip(Trip trip) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(trip);
        session.getTransaction().commit();
        session.close();
    }


    public Trip getTripById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Trip trip = null;
        trip = session.get(Trip.class, id);
        session.getTransaction().commit();
        session.close();
        return trip;

    }


    public void deleteById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Trip trip = null;
        trip = getTripById(id);
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
        session.close();
    }


    @Override
    public List<Trip> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return  session.createQuery("SELECT t FROM Trip t", Trip.class).getResultList();
    }

    public List<Trip> get(int offset, int perPage, String sort) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Trip> trips=null;
        Query query=session.createQuery("select t from Trip  t order by t." + sort + " DESC").
                setMaxResults(perPage).setFirstResult(offset);

        trips= query.getResultList();
        session.close();
        return trips;
    }

    public List<Trip> getTripsFrom(String city) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Trip> trips=null;
        Query query=session.createQuery("select t from Trip  t where townFrom=:TOWNFROM").
                setParameter("TOWNFROM",city);
        trips= query.getResultList();
        session.close();
        return trips;
    }

    public List<Trip> getTripsTo(String city) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Trip> trips=null;
        Query query=session.createQuery("select t from Trip  t where townTo=:TOWNTO").
                setParameter("TOWNTO",city);
        trips= query.getResultList();
        session.close();
        return trips;
    }
}
