package service.impl;

import dao.impl.CompanyDaoImpl;
import dao.impl.PassengerDaoImpl;
import model.Company;
import model.Passenger;
import org.hibernate.SessionFactory;

import java.util.Set;


public class PassengerServiceImpl {
   PassengerDaoImpl passengerDao=new PassengerDaoImpl();


    public void getById(long id) {

    }


    public Set<Company> getAll() {
        return null;
    }


    public Set<Company> get(int offset, int perPage, String sort) {
      return  null;
    }


    public void save(Passenger passenger, SessionFactory sessionFactory){
        passengerDao.createPassenger(passenger,sessionFactory);


    }


    public void update(Long id,Passenger passenger, SessionFactory sessionFactory) {

    }


    public void delete(long companyId) {

    }



}
