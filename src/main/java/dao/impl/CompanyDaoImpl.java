package dao.impl;

import dao.CompanyDao;
import model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

public class CompanyDaoImpl implements CompanyDao {

    public void createCompany(Company company, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public void update( Company company, SessionFactory sessionFactory) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Company getCompanyById(long id) {

        return null;
    }

    @Override
    public Set<Company> getAll() {
        return null;
    }
}
