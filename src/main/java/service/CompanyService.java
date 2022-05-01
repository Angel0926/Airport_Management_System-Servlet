package service;

import model.Company;
import org.hibernate.SessionFactory;

import java.util.Set;

public interface CompanyService {

    void getById(long id,SessionFactory sessionFactory);


    void update(Long id, SessionFactory sessionFactory, Company company);

    Set<Company> getAll();

    Set<Company> get(int offset, int perPage, String sort);

    public void save(Company company, SessionFactory sessionFactory);



    void delete(long companyId, SessionFactory sessionFactory);
}
