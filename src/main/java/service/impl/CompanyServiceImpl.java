package service.impl;

import dao.impl.CompanyDaoImpl;
import model.Company;
import org.hibernate.SessionFactory;
import service.CompanyService;

import java.util.Set;


public class CompanyServiceImpl implements CompanyService {

    private  SessionFactory sessionFactory;


    public CompanyServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    CompanyDaoImpl companyDao=new CompanyDaoImpl(sessionFactory);
    @Override
    public void save(Company company) {
        companyDao.createCompany(company);
    }

    @Override
    public void getById(long id) {
        System.out.println(companyDao.getCompanyById(id));
    }

    @Override
    public void delete(long id) {

        companyDao.deleteById(id);
    }
    @Override
    public void update(Long id,  Company company) {
      companyDao.update(id,company);
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
