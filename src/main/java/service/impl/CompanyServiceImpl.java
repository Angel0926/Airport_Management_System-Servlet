package service.impl;

import dao.impl.CompanyDaoImpl;
import model.Company;
import org.hibernate.SessionFactory;
import service.CompanyService;

import java.util.Set;


public class CompanyServiceImpl implements CompanyService {
    CompanyDaoImpl companyDao = new CompanyDaoImpl();


    @Override
    public void save(Company company, SessionFactory sessionFactory) {
        companyDao.createCompany(company, sessionFactory);
    }

    @Override
    public void getById(long id, SessionFactory sessionFactory) {
        System.out.println(companyDao.getCompanyById(id, sessionFactory));
    }

    @Override
    public void delete(long id, SessionFactory sessionFactory) {

        companyDao.deleteById(id, sessionFactory);
    }
    @Override
    public void update(Long id, SessionFactory sessionFactory, Company company) {
      companyDao.update(id,sessionFactory,company);
    }


    @Override
    public Set<Company> getAll() {
        return null;
    }

    @Override
    public Set<Company> get(int offset, int perPage, String sort) {
        return null;
    }






}
