package service.impl;

import config.HibernateConfigUtil;
import dao.impl.CompanyDaoImpl;
import model.Company;
import org.hibernate.SessionFactory;
import service.CompanyService;

import java.util.List;


public class CompanyServiceImpl implements CompanyService {

    private final CompanyDaoImpl companyDao = new CompanyDaoImpl();


    @Override
    public void save(Company company) {
        companyDao.createCompany(company);
    }

    @Override
    public Company getById(long id) {
        Company companyById = companyDao.getCompanyById(id);
        System.out.println(companyById);
        return companyById;
    }

    @Override
    public void delete(long id) {
        companyDao.deleteById(id);
    }

    @Override
    public void update(Long id, Company company) {
        companyDao.update(id, company);
    }


    @Override
    public List<Company> getAll() {
        return companyDao.getAll();
    }

    @Override
    public List<Company> get(int offset, int perPage, String sort) {
        return companyDao.get(offset,perPage,sort);

    }


}
