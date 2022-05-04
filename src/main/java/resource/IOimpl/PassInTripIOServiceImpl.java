package resource.IOimpl;


import dao.PassInTripDao;
import dao.impl.PassInTripDaoImpl;
import model.PassInTrip;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class PassInTripIOServiceImpl {
    private  SessionFactory sessionFactory;

    public PassInTripIOServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public  void createPassInTripFromFile() {
        PassInTripDao passInTripDao = new PassInTripDaoImpl(sessionFactory);

        PassInTrip passInTrip = new PassInTrip();
        String[] words;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/resource/pass_in_trip.txt"))
        ) {
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                line = line.replace("'", "");
                words = line.split(",");
                passInTrip.setTripId(Long.parseLong(words[0]));
                passInTrip.setPsgId(Long.parseLong(words[1]));
                passInTrip.setDate(LocalDate.parse(words[2],
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
                passInTrip.setPlace(words[3]);
                passInTripDao.createPassInTrip(passInTrip);
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
