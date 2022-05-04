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

    private  SessionFactory sessionFactory;
    private  CompanyDaoImpl companyDao;

    public TripIOServiceImpl(SessionFactory sessionFactory, CompanyDaoImpl companyDao) {
        this.sessionFactory = sessionFactory;
        this.companyDao = companyDao;
    }

    public void createPassengerFromFile() {
        TripDaoImpl tripDao = new TripDaoImpl(sessionFactory);
        Trip trip = new Trip();
        String[] words;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/resource/trip.txt"))
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


                company=companyDao.getCompanyById(Long.parseLong(words[1]));
                trip.setCompany(company);

                trip.setPlane(words[2]);
                trip.setTownFrom(words[3]);
                trip.setTownTo(words[4]);
                trip.setTimeOut(LocalDateTime.parse(words[5],
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")).toLocalTime());
                trip.setTimeIn(LocalDateTime.parse(words[6],
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")).toLocalTime());

                tripDao.createTrip(trip);
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
