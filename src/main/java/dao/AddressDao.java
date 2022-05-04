package dao;

import model.Address;
import org.hibernate.SessionFactory;

import java.util.Set;

public interface AddressDao {

    void createAddress(Address address);


    Address getAddressById(long id);

    void update(long id, Address address);


    void deleteById(long id);

    Set<Address> getAll();
}
