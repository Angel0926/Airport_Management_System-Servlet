package dao.impl;

import dao.CompanyDao;
import model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.Set;

public class CompanyDaoImpl implements CompanyDao {
    private  SessionFactory sessionFactory;

    public CompanyDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCompany(Company company) {
        Session session;
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(company);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void deleteById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Company company = null;
        company=getCompanyById(id);
        session.delete(company);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Company getCompanyById(long id) {
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
    public void update(long id, Company company) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Company old = getCompanyById(id);
        old.setCompanyName(company.getCompanyName());
        old.setFoundingDate(company.getFoundingDate());
        session.update(old);
        session.getTransaction().commit();
        sessionFactory.close();
    }





    public Set<Company> getAll() {

   return null;
    }
}
