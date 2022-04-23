package resource.IOimpl;

import dao.impl.TripDaoImpl;
import model.Trip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TripIOimpl {
    public static void getTripFromFile() {

        TripDaoImpl tripDao=new TripDaoImpl();
       Trip trip=new Trip();
        String[] words;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/resource/trip"))
        ) {
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                line = line.replace("'", "");
                words = line.split(",");

                trip.setId(Long.parseLong(words[0]));
                trip.setIdComp(Long.parseLong(words[1]));
                trip.setPlane(words[2]);
                trip.setTownFrom(words[3]);
                trip.setTownTo(words[4]);
                trip.setTimeOut(LocalDateTime.parse(words[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")).toLocalTime());
                trip.setTimeIn(LocalDateTime.parse(words[6], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")).toLocalTime());
                tripDao.createTrip(trip);
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
