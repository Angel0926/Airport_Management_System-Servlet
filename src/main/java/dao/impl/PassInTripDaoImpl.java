package dao.impl;

import dao.PassInTripDao;
import model.PassInTrip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class PassInTripDaoImpl implements PassInTripDao {
    private SessionFactory sessionFactory;

    public PassInTripDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createPassInTrip(PassInTrip passInTrip) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(passInTrip);
        session.getTransaction().commit();
        session.close();
    }
}
