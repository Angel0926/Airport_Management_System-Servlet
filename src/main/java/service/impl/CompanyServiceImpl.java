package service.impl;

import dao.impl.CompanyDaoImpl;
import model.Company;
import service.CompanyService;

import java.util.Set;


public class CompanyServiceImpl implements CompanyService {
    CompanyDaoImpl cdi=new CompanyDaoImpl();
    @Override
    public void getById(long id) {
        cdi.getCompanyById(id);
    }

    @Override
    public void getAll() {
        cdi.getAll();
    }

    @Override
    public Set<Company> get(int offset, int perPage, String sort) {
        return null;
    }

    @Override
    public void save(Company company) {
        cdi.createCompany(company);
    }

    @Override
    public void update(long id, Company company) {
       cdi.update(id, company);
    }

    @Override
    public void delete(long companyId) {
cdi.deleteById(companyId);
    }
}
