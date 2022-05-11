package service.impl;

import config.SessionFactoryUtil;
import model.Company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceImplTest {
    private static final Configuration configuration = new Configuration();

    private final SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
    private final CompanyServiceImpl companyService = new CompanyServiceImpl();
    private Company company;
    @AfterEach
    public void cleanDatabase() {
        String queryStr2 = "DELETE FROM Company";
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query query2 = session.createQuery(queryStr2);
        query2.executeUpdate();
        transaction.commit();
        session.clear();
        session.close();

    }

    @BeforeEach
    void before(){
     company = new Company();
        company.setCompanyName("ddssd");
        company.setFoundingDate(LocalDate.now());

    }


    @Test
    void save() {
        companyService.save(company);
        Company byId = companyService.getById(1);
        assertNotNull(byId);
    }

    @Test
    void getById() {
        companyService.save(company);
        Company byId = companyService.getById(1);
        assertNotNull(byId);
        assertEquals("AEGEAN",byId.getCompanyName());
    }

    @Test
    void delete() {
        companyService.save(company);
        companyService.delete(1);
        Company byId = companyService.getById(1);
        assertNull(byId);

    }

    @Test
    void update() {
        companyService.save(company);
        Company byId = companyService.getById(1);
        assertNotNull(byId);
        assertEquals("AEGEAN",byId.getCompanyName());
        Company company = new Company("UT",LocalDate.now());
        companyService.update(1L,company);
        Company updated = companyService.getById(1);
        assertEquals("UT",updated.getCompanyName());
    }

    @Test
    void getAll() {
        companyService.save(company);
        companyService.save(new Company("UT",LocalDate.now()));
        companyService.save(new Company("YNDZT",LocalDate.now()));
        List<Company> all = companyService.getAll();
        assertNotNull(all);
        assertEquals(3,all.size());
    }

    @Test
    void get() {
        companyService.save(company);
        companyService.save(new Company("UT",LocalDate.now()));
        companyService.save(new Company("YNDZT",LocalDate.now()));
        List<Company> companies = companyService.get(0, 3, "companyName");
        assertNotNull(companies);
        assertEquals(3,companies.size());
    }
}