package dao.impl;

import config.HibernateConfigUtil;
import dao.PassInTripDao;
import model.PassInTrip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class PassInTripDaoImpl implements PassInTripDao {
    private final SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();


    public void createPassInTrip(PassInTrip passInTrip) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(passInTrip);
        session.getTransaction().commit();
        session.close();
    }
}
