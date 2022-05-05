package service.impl;

import dao.impl.TripDaoImpl;
import model.Company;
import model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import service.TripService;

import java.util.List;


public class TripServiceImpl implements TripService {

    private final SessionFactory sessionFactory;
    private TripDaoImpl tripDao;

    public TripServiceImpl(SessionFactory sessionFactory, TripDaoImpl tripDao) {
        this.sessionFactory = sessionFactory;
        this.tripDao = tripDao;
    }

    @Override
    public void save(Trip trip) {

        tripDao.createTrip(trip);
    }

    @Override
    public void getById(long id) {
        System.out.println(tripDao.getTripById(id));
    }

    @Override
    public void update(Long id, Trip trip) {
        tripDao.update(id, trip);
    }

    @Override
    public void delete(long id) {
        tripDao.deleteById(id);
    }

    @Override
    public void getAll() {
        tripDao.getAll();
    }

    @Override
    public List<Trip> get(int offset, int perPage, String sort) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Trip> trips=null;
        Query query=session.createQuery("select t from Trip  t order by :SORT").setParameter("SORT",sort).
                setMaxResults(perPage).setFirstResult(offset);

        trips= query.getResultList();
        session.close();
        return trips;
    }


    @Override
    public List getTripsFrom(String city) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Trip> trips=null;
        Query query=session.createQuery("select t from Trip  t where townFrom=:TOWNFROM").
                setParameter("TOWNFROM",city);
        trips= query.getResultList();
        session.close();
        return trips;
    }

    @Override
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
