package dao;

import model.Address;
import org.hibernate.SessionFactory;

import java.util.Set;

public interface AddressDao {

    void createAddress(Address address, SessionFactory sessionFactory);


    Address getAddressById(long id,SessionFactory sessionFactory);

    void update(long id, SessionFactory sessionFactory, Address address);

    Set<Address> getAll();

    void deleteById(long id, SessionFactory sessionFactory);
}
