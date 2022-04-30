package service.impl;

import dao.impl.AddressDaoImpl;
import dao.impl.CompanyDaoImpl;
import model.Address;
import model.Company;
import org.hibernate.SessionFactory;

import java.util.Set;


public class AddressServiceImpl {
   AddressDaoImpl addressDao=new AddressDaoImpl();

    public void getById(long id) {

    }


    public Set<Address> getAll() {
        return null;
    }


    public Set<Address> get(int offset, int perPage, String sort) {
      return  null;
    }


    public void save(Address address, SessionFactory sessionFactory){
       addressDao.createAddress(address,sessionFactory);


    }


    public void update(Long id,Address address, SessionFactory sessionFactory) {
//addressDao.update(address,sessionFactory);
    }


    public void delete(long addressId) {

    }



}
