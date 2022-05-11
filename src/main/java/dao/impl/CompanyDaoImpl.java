package dao.impl;

import config.SessionFactoryUtil;
import dao.CompanyDao;
import model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CompanyDaoImpl implements CompanyDao {
    private final SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();


    @Override
    public void createCompany(Company company) {
        Session session = sessionFactory.openSession();
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
        Company company = session.get(Company.class, id);
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
