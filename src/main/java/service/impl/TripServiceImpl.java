package service.impl;

import dao.impl.CompanyDaoImpl;
import model.Company;
import org.hibernate.SessionFactory;

import java.util.Set;


public class TripServiceImpl {
    CompanyDaoImpl companyDao = new CompanyDaoImpl();

    public void getById(long id) {

    }


    public Set<Company> getAll() {
        return null;
    }


    public Set<Company> get(int offset, int perPage, String sort) {
      return  null;
    }


    public void save(Company company, SessionFactory sessionFactory){
        companyDao.createCompany(company,sessionFactory);


    }


    public void update(Long id,Company company, SessionFactory sessionFactory) {
companyDao.update(company,sessionFactory);
    }


    public void delete(long companyId) {

    }



}
