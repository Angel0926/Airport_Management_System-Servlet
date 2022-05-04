package service;

import model.Company;
import org.hibernate.SessionFactory;

import java.util.Set;

public interface CompanyService {

    void getById(long id);


    void update(Long id, Company company);

    Set<Company> getAll();

    Set<Company> get(int offset, int perPage, String sort);

    public void save(Company company);



    void delete(long companyId);
}
