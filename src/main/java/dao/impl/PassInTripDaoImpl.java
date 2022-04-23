package dao.impl;

import dao.PassInTripDao;
import model.PassInTrip;
import service.DatabaseConnectionService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PassInTripDaoImpl implements PassInTripDao {
    @Override
    public  void createPassInTrip(PassInTrip passInTrip) {
        Connection connection =
                DatabaseConnectionService.DB_INSTANCE.createConnection();

        String query =
                "INSERT INTO Pass_In_Trip (trip_id, date,psg_id, place)" +
                        " VALUES ('" +
                        passInTrip.getIdTrip() + "', '" +
                        passInTrip.getDate() + "', '" +
                        passInTrip.getIdPsg() + "', '" +
                        passInTrip.getPlace()  + "');";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
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
        }
    }
}
