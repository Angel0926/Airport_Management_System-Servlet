import dao.impl.CompanyDaoImpl;
import model.Company;
import model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;
import service.impl.CompanyServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CompanyServiceImplTest {
    static Configuration configuration = new Configuration();
    private static SessionFactory sessionFactory;
    private Session session;

    private final CompanyServiceImpl companyService = new CompanyServiceImpl();

    @BeforeAll
    public static void setup() {
        sessionFactory = configuration.buildSessionFactory();
        System.out.println("SessionFactory created");
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }

    @Test
    public void testCreate() {
        Company company = new Company("sdd", LocalDate.now());
        companyService.save(company);

    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testList() {
    }

    @Test
    public void testDelete() {
    }

    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
        System.out.println("Session created");
    }

    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }
}
