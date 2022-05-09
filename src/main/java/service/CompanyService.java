package service;

import model.Company;

import java.util.List;

public interface CompanyService {

    Company getById(long id);

    void delete(long id);

    void update(Long id, Company company);

    List<Company> getAll();

    List<Company> get(int offset, int perPage, String sort);

    public void save(Company company);

}
