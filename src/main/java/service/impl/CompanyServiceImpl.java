package service.impl;

import dao.impl.CompanyDaoImpl;
import model.Company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import service.CompanyService;

import java.util.List;


public class CompanyServiceImpl implements CompanyService {

    private SessionFactory sessionFactory;
    private final CompanyDaoImpl companyDao;

    public CompanyServiceImpl(SessionFactory sessionFactory, CompanyDaoImpl companyDao) {
        this.sessionFactory = sessionFactory;
        this.companyDao = companyDao;
    }

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
    public void update(Long id, Company company) {
        companyDao.update(id, company);
    }


    @Override
    public void getAll() {
        companyDao.getAll();
    }

    @Override
    public List<Company> get(int offset, int perPage, String sort) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Company> companies = null;
        String sql = "SELECT c FROM Company c ORDER BY c." + sort + " DESC";
        Query query = session.createQuery(sql).
                setMaxResults(perPage).setFirstResult(offset);
        companies = query.getResultList();
        session.close();
        return companies;

    }


}
