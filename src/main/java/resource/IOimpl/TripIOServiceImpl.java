package resource.IOimpl;


import dao.impl.CompanyDaoImpl;
import dao.impl.TripDaoImpl;
import model.Company;
import model.Trip;
import org.hibernate.SessionFactory;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TripIOServiceImpl {

    public static void createPassengerFromFile(SessionFactory sessionFactory) {
        TripDaoImpl tripDao = new TripDaoImpl();
        Trip trip = new Trip();
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
                Company company = null;
                trip.setId(Long.parseLong(words[0]));
                CompanyDaoImpl companyDao = new CompanyDaoImpl();

                company=companyDao.getCompanyById(Long.parseLong(words[1]), sessionFactory);
                trip.setCompany(company);

                trip.setPlane(words[2]);
                trip.setTownFrom(words[3]);
                trip.setTownTo(words[4]);
                trip.setTimeOut(LocalDateTime.parse(words[5],
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")).toLocalTime());
                trip.setTimeIn(LocalDateTime.parse(words[6],
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")).toLocalTime());

                tripDao.createTrip(trip, sessionFactory);
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
