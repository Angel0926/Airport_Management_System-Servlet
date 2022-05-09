
import model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import java.io.Serializable;
import java.time.LocalTime;


public class TripImplServiceTest implements Serializable {
    static Configuration configuration = new Configuration();
    private static SessionFactory sessionFactory;
    private Session session;

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
    public void testCreate(Trip trip) {
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
