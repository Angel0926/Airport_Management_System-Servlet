package dao;

import model.Company;

import java.util.List;

public interface CompanyDao {

    void update(long id,  Company company);


    void createCompany(Company company);

    void deleteById(long id);

    Company getCompanyById(long id);

    List<Company> getAll();


}
