package service.impl;

import dao.impl.PassengerDaoImpl;
import model.Company;
import model.Passenger;
import model.Trip;
import service.DatabaseConnectionService;
import service.PassengerService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PassengerServiceImpl implements PassengerService {
    PassengerDaoImpl passengerDao=new PassengerDaoImpl();
    @Override
    public void getById(long id) {

       passengerDao.getPassengerById(id);
    }

    @Override
    public void getAll() {
        passengerDao.getAll();
    }

    @Override
    public Set<Passenger> get(int offset, int perPage, String sort) {
     /* SELECT *
  from Passenger
        order by pass_name
        LIMIT 5 OFFSET 10 */
        Set<Passenger> passengeres = null;
        try (Connection connection = DatabaseConnectionService
                .DB_INSTANCE.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet =
                     statement.executeQuery(
                             "SELECT * FROM Passenger " +
                                     "order by " + sort + " limit " + perPage +
                                     " OFFSET " + offset + ";")) {

            passengeres = new HashSet<>();
            Passenger passenger;
            while (resultSet.next()) {
                passenger = new Passenger(
                        resultSet.getLong("address_id"),
                        resultSet.getString("pass_name"),
                        resultSet.getString("pass_phone")

                );
                passengeres.add(passenger);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return passengeres;
    }


    @Override
    public void save(Passenger passenger) {
       passengerDao.createPassenger(passenger);
    }

    @Override
    public void update(long id, Passenger passenger) {
        passengerDao.update(id,passenger);
    }

    @Override
    public void delete(long passengerId) {
passengerDao.deleteById(passengerId);
    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
      /*  SELECT pass_name
        from passenger
        join pass_in_trip pst on passenger.id=pst.psg_id
        where trip_id=1145;*/
        Statement statement=null;
        List<Passenger> passengeres = null;
        Connection connection = DatabaseConnectionService
                .DB_INSTANCE.createConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(
                    "SELECT pass_name"+"FROM Passenger " +
                            "join pass_in_trip pst  on  passenger.id=pst.psg_id"+
                            "where trip_id="+tripNumber+";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        {

            passengeres = new LinkedList<>();
            Passenger passenger;
            while (true) {
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    passenger = new Passenger(
                            resultSet.getLong("address_id"),
                            resultSet.getString("pass_name"),
                            resultSet.getString("pass_phone")

                    );
                    passengeres.add(passenger);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
         finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }}

        return passengeres;
    }}

    @Override
    public void registerTrip(Trip trip, Passenger passenger) {


    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }
}
