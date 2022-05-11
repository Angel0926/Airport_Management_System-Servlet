package dao.impl;

import config.SessionFactoryUtil;
import dao.AddressDao;
import model.Address;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import resource.IOimpl.AddressIOServiceImpl;


import java.util.Set;

public class AddressDaoImpl implements AddressDao {

    private final SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

    public void createAddress(Address address) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(address);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Address address = null;
        address = getAddressById(id);
        session.remove(address);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Address getAddressById(long id) {
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
    public void update(long id, Address address) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Address old = getAddressById(id);
        old.setCountry(address.getCountry());
        old.setCity(address.getCity());
        session.merge(old);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Set<Address> getAll() {
        AddressIOServiceImpl addressIOService = new AddressIOServiceImpl();

        return addressIOService.createAddressFromFile();
    }
}