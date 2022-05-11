package service.impl;

import config.SessionFactoryUtil;
import dao.impl.CompanyDaoImpl;
import model.Company;
import model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripServiceImplTest {
    private static final Configuration configuration = new Configuration();
    private final TripServiceImpl tripService = new TripServiceImpl();
    private final CompanyDaoImpl companyDao = new CompanyDaoImpl();
    private final SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
    private Trip trip;
    private Company company;


    @AfterEach
    public void cleanDatabase() {
        String queryStr = "DELETE FROM Trip";
        String queryStr2 = "DELETE FROM Company";
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query query = session.createQuery(queryStr);
        Query query2 = session.createQuery(queryStr2);
        query.executeUpdate();
        query2.executeUpdate();
        transaction.commit();
        session.clear();
        session.close();
        trip.getPassengers();
    }


    @BeforeEach
    void beforeEach() {
        Company transComp = new Company();
        transComp.setCompanyName("ddssd");
        transComp.setFoundingDate(LocalDate.now());
        companyDao.createCompany(transComp);
        //company = companyDao.getCompanyById(1);

        trip = new Trip();
        trip.setId(1);
        trip.setPlane("aaaa");
        trip.setTownFrom("bbbb");
        trip.setTownTo("cccc");
        trip.setTimeIn(LocalTime.MIN);
        trip.setTimeOut(LocalTime.MAX);
        trip.setCompany(transComp);

    }

    @Test
    void save() {
        tripService.save(trip);
        Trip byId = tripService.getById(1);
        assertNotNull(byId);

    }

    @Test
    void getById() {
        tripService.save(trip);
        Trip byId = tripService.getById(1);
        assertNotNull(byId);

    }

    @Test
    void update() {
       tripService.save(trip);
        Trip trip1 = new Trip("dsf", "fdg", "Fff", LocalTime.MAX, LocalTime.MIN);
        tripService.update(1L, trip1);
        Trip byId = tripService.getById(1);
        assertEquals("dsf", byId.getPlane());
    }

    @Test
    void delete() {

        tripService.save(trip);
        Trip byId = tripService.getById(1);
        assertNotNull(byId);
        tripService.delete(1);
        Trip deleted = tripService.getById(1);
        assertNull(deleted);
    }

    @Test
    void getAll() {
        tripService.save(trip);
        Trip trip = new Trip("dgsf", "dfdg", "vFff", LocalTime.MAX, LocalTime.MIN);
        trip.setCompany(company);
        tripService.save(trip);
        List<Trip> all = tripService.getAll();
        assertEquals(2, all.size());
    }

    @Test
    void get() {
        tripService.save(trip);
        List<Trip> trips = tripService.get(0, 1, "plane");
        assertNotNull(trips);
        assertEquals(1, trips.size());
    }

    @Test
    void getTripsFrom() {
    }

    @Test
    void getTripsTo() {
    }

}