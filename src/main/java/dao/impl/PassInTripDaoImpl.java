package dao.impl;

import dao.PassInTripDao;
import model.PassInTrip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PassInTripDaoImpl implements PassInTripDao {
    @Override
    public void createPassInTrip(PassInTrip passInTrip, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(passInTrip);
        session.getTransaction().commit();
        session.close();
    }
}
