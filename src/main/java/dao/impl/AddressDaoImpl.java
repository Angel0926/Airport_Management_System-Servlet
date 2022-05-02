package dao.impl;

import dao.AddressDao;
import model.Address;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AddressDaoImpl implements AddressDao {

    public void createAddress(Address address, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteById(long id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Address address = null;
        address = getAddressById(id, sessionFactory);
        session.remove(address);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Address getAddressById(long id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Address address = null;
        try {
            address = session.get(Address.class, id);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (session != null) session.close();
            } catch (Exception ex) {
            }
        }
        return address;
    }

    @Override
    public void update(long id, SessionFactory sessionFactory, Address address) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Address old = getAddressById(id, sessionFactory);
            old.setCountry(address.getCountry());
            old.setCity(address.getCity());
            session.update(old);
            session.getTransaction().commit();
            sessionFactory.close();
        }

    @Override
    public Set<Address> getAll() {
        return null ;
    }

}
