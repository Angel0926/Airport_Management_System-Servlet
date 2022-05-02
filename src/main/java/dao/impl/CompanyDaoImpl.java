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
    public void deleteById(long id,SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Company company = null;
        company=getCompanyById(id,sessionFactory);
        session.delete(company);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Company getCompanyById(long id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Company company = null;
        try {

            company= session.get(Company.class, id);

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {

            try {if(session != null) session.close();} catch(Exception ex) {}
        }
        return company;
    }

    @Override
    public void update(long id, SessionFactory sessionFactory, Company company) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Company old = getCompanyById(id, sessionFactory);
        old.setCompanyName(company.getCompanyName());
        old.setFoundingDate(company.getFoundingDate());
        session.update(old);
        session.getTransaction().commit();
        sessionFactory.close();
    }




    @Override
    public Set<Company> getAll() {
        return null;
    }
}
