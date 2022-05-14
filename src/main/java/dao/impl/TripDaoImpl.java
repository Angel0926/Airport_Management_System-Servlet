package dao.impl;

import dao.util.HibernateUtil;
import dao.TripDao;

import model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class TripDaoImpl implements TripDao {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    @Override
    public void createTrip(Trip trip) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(trip);
        session.getTransaction().commit();
        session.close();
    }


    public Trip getTripById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Trip trip = session.get(Trip.class, id);
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
        String hql = "UPDATE Trip T SET  T.plane = :plane," +
                " T.townFrom = :townFrom, T.townTo = :townTo," +
                "T.timeOut = :timeOut, T.timeIn = :timeIn WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        query.setParameter("plane",trip.getPlane());
        query.setParameter("townFrom",trip.getTownFrom());
        query.setParameter("townTo",trip.getTownTo());
        query.setParameter("timeOut",trip.getTimeOut());
        query.setParameter("timeIn",trip.getTimeIn());
        query.executeUpdate();
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
