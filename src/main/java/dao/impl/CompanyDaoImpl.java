package dao.impl;

import dao.CompanyDao;
import model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CompanyDaoImpl implements CompanyDao {
    private final SessionFactory sessionFactory;

    public CompanyDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
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
        company = getCompanyById(id);
        session.delete(company);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Company getCompanyById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Company company = null;
        company = session.get(Company.class, id);

        session.getTransaction().commit();
        session.close();
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
        session.close();
    }

    @Override
    public List<Company> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return  session.createQuery("SELECT c FROM Company c", Company.class).getResultList();

    }
}
