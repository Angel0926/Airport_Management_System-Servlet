package resource.IOimpl;

import dao.PassInTripDao;
import dao.impl.AddressDaoImpl;
import dao.impl.PassInTripDaoImpl;
import model.Address;
import model.PassInTrip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PassInTripIOImpl {

    public static void getPassInTripFromFile() {

        PassInTripIOImpl passInTripIO = new PassInTripIOImpl();
        PassInTripDao passInTripDao=new PassInTripDaoImpl();
        PassInTrip passInTrip=new PassInTrip();
        String[] words;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/resource/pass_in_trip"))
        ) {
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                line = line.replace("'", "");
                words = line.split(",");
                passInTrip.setIdTrip(Long.parseLong(words[0]));
                passInTrip.setIdPsg(Long.parseLong(words[1]));
                passInTrip.setDate(LocalDate.parse(words[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
                passInTrip.setPlace(words[3]);
                passInTripDao. createPassInTrip(passInTrip);
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
