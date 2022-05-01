package dao;

import model.Company;
import org.hibernate.SessionFactory;

import java.util.Set;

public interface CompanyDao {


    void update(long id, Company company, SessionFactory sessionFactory);

    void update(Company company, SessionFactory sessionFactory);



    void deleteById(long id, SessionFactory sessionFactory);

    Company getCompanyById(long id, SessionFactory sessionFactory);

    Set<Company> getAll();
}
