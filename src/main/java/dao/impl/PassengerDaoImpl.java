package dao.impl;

import dao.PassengerDao;

import model.Address;
import model.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

public class PassengerDaoImpl implements PassengerDao {
AddressDaoImpl a=new AddressDaoImpl();
Address ad=null;
    @Override
    public void createPassenger(Passenger passenger, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(passenger);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public Passenger getPassengerById(long id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Passenger passenger = null;
        try {

            passenger= session.get(Passenger.class, id);

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {

            try {if(session != null) session.close();} catch(Exception ex) {}
        }
        return passenger;
    }

    @Override
    public void deleteById(long id,SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Passenger passenger = null;
        passenger=getPassengerById(id,sessionFactory);
        session.delete(passenger);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void update(long id, Passenger passenger, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Passenger old = getPassengerById(id, sessionFactory);
        old.setPhone(passenger.getPhone());
        old.setName(passenger.getName());
        session.update(old);
        session.getTransaction().commit();
        sessionFactory.close();
    }





    @Override
    public Set<Passenger> getAll() {
       return  null;
    }

}

