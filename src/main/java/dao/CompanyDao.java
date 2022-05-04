package dao;

import model.Company;
import org.hibernate.SessionFactory;

import java.util.Set;

public interface CompanyDao {



    void update(long id,  Company company);


    void deleteById(long id);

    Company getCompanyById(long id);

    Set<Company> getAll();


}
