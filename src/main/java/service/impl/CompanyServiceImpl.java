package service.impl;

import dao.impl.CompanyDaoImpl;
import model.Company;
import model.Passenger;
import service.CompanyService;
import service.DatabaseConnectionService;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class CompanyServiceImpl implements CompanyService {
    CompanyDaoImpl cdi=new CompanyDaoImpl();
    @Override
    public void getById(long id) {
        cdi.getCompanyById(id);
    }

    @Override
    public Set<Company> getAll() {
      return   cdi.getAll();
    }

    @Override
    public Set<Company> get(int offset, int perPage, String sort) {
       /* SELECT *
                from company
        order by company_name
        LIMIT 5 OFFSET 10*/

        Set<Company> companies = null;
        try (Connection connection = DatabaseConnectionService
                .DB_INSTANCE.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet =
                     statement.executeQuery(
                             "SELECT * FROM company " +
                                     "order by " + sort + " limit " + perPage +
                                     " OFFSET " + offset + ";")) {

            companies = new HashSet<>();
            Company company;
            while (resultSet.next()) {
                company = new Company(
                        resultSet.getString("company_name"),
                        resultSet.getDate("founding_date").toLocalDate()
                );
                companies.add(company);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return companies;
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
