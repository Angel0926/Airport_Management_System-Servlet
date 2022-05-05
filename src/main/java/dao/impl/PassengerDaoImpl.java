package dao.impl;

import dao.PassengerDao;

import model.Address;
import model.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PassengerDaoImpl implements PassengerDao {
    private SessionFactory sessionFactory;

    public PassengerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    AddressDaoImpl a = new AddressDaoImpl();
    Address ad = null;

    @Override
    public void createPassenger(Passenger passenger) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(passenger);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public Passenger getPassengerById(long id) {
        Session session = sessionFactory.openSession();
        Passenger passenger = null;
        try {
            passenger = session.get(Passenger.class, id);
            // System.out.println(passenger.getAddress());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (session != null) session.close();
            } catch (Exception ex) {
            }
            System.out.println(passenger);
        }
        return passenger;
    }


    @Override
    public List<Passenger> get(int offset, int perPage, String sort) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Passenger> passengers=null;
        Query query=session.createQuery("select p from Passenger p order by :SORT").setParameter("SORT",sort).
       setMaxResults(perPage).setFirstResult(offset);

        passengers= query.getResultList();
        session.close();
        return passengers;
    }


    @Override
    public void deleteById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Passenger passenger = null;
        passenger = getPassengerById(id);
        session.delete(passenger);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(long id, Passenger passenger) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Passenger old = getPassengerById(id);
        old.setPhone(passenger.getPhone());
        old.setName(passenger.getName());
        session.merge(old);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public List<Passenger> getAll() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return  session.createQuery("SELECT p FROM Passenger p", Passenger.class).getResultList();
    }

}

