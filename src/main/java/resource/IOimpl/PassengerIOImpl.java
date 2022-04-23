package resource.IOimpl;

import dao.impl.PassengerDaoImpl;
import model.Passenger;
import service.DatabaseConnectionService;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerIOImpl {
    public static void getPassengersFromFile() {
        Passenger passenger = new Passenger();
        PassengerDaoImpl passengerDao = new PassengerDaoImpl();
        File file = new File("src/main/java/resource/passengers.txt");
        String line;
        String[] words;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (line.contains("'")) {
                line = line.replace("'", "՛");
            }

            words = line.split(",");
            for (int i = 0; i < words.length; i++) {
                System.out.print(words[i] + " ");
                passenger.setName(words[0]);
                passenger.setPhone(words[1]);
                passenger.setIdAddress(addressIDCommit(words));
            }

            passengerDao.createPassenger(passenger);
            System.out.println();
        }
        try {
            System.out.println();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int addressIDCommit(String[] word) {
        int addresId=0;
        Connection connection =
                DatabaseConnectionService.DB_INSTANCE.createConnection();

        PreparedStatement statement = null;

        try {
            try {
                statement = connection.prepareStatement(
                        "SELECT id " +
                                "FROM address " +
                                "WHERE country = ? AND city = ?;"
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            statement.setString(1, word[2].replace("'", ""));
            statement.setString(2, word[3].replace("'", ""));

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                addresId = rs.getInt("id");
            }
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
        return addresId;
    }
}

