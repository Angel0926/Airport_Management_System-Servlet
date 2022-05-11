package service.impl;

import config.SessionFactoryUtil;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassengerServiceImplTest {

    private final PassengerServiceImpl passengerService = new PassengerServiceImpl();
    private Passenger passenger;
    private Address address;
    private final SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

    @AfterEach
    void cleanDatabase() {
        passenger.getPhone();
        String queryStr = "DELETE FROM Passenger";
        String queryStr2 = "DELETE FROM Address";
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery(queryStr);
        Query query2 = session.createQuery(queryStr2);
        query.executeUpdate();
        query2.executeUpdate();
        passenger.getPhone();
        session.close();


    }

    @BeforeEach
    void beforeEach() {
        address = new Address();
        address.setCity("uhjj");
        address.setCountry("Armenia");

        passenger = new Passenger();
        passenger.setName("poxos");
        passenger.setPhone("123456");
        passenger.setAddress(address);

    }

    @Test
    void save() {
        passengerService.save(passenger);
        Passenger byId = passengerService.getById(1);
        Assert.assertTrue(byId.getId()==1);

    }


    @Test
    void getById() {
        passengerService.save(passenger);
        Passenger byId = passengerService.getById(1);
        assertNotNull(byId);
    }

    @Test
    void delete() {
        passengerService.save(passenger);
        Passenger byId = passengerService.getById(1);
        assertNotNull(byId);
        passengerService.delete(1);
        Passenger deleted = passengerService.getById(1);
        assertNull(deleted);
    }

    @Test
    void update() {
        passengerService.save(passenger);
        Passenger passenger = new Passenger("petros", "123456");
        passenger.setAddress(address);
        passengerService.update(1, passenger);
        Passenger byId = passengerService.getById(1);
        assertEquals("petros", byId.getName());
    }


    @Test
    void getAll() {
        passengerService.save(passenger);
        Passenger passenger = new Passenger("petros", "12345556");
        passenger.setAddress(address);
        Passenger passenger1 = new Passenger("martiros", "459842");
        passenger1.setAddress(address);
        passengerService.save(passenger);
        passengerService.save(passenger1);
        List<Passenger> all = passengerService.getAll();
        assertEquals(3, all.size());
    }

//    @Test
//    void registerTrip() {
//
//
//    }

    @Test
    void get() {
        passengerService.save(passenger);
        List<Passenger> passengers = passengerService.get(0, 1, "name");
        assertNotNull(passengers);
        assertEquals(1, passengers.size());
    }

//    @Test
//    void getPassengersOfTrip() {
//
//
//    }
//
//    @Test
//    void cancelTrip() {
//    }
}