package dao.impl;

import dao.AddressDao;
import model.Address;
import model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
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
    public void update(long id, Address address) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Address getAddressById(long id) {
       return  null;
    }

    @Override
    public Set<Address> getAll() {
return  null;

}}
