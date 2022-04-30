package resource.IOimpl;

import dao.impl.AddressDaoImpl;
import dao.impl.CompanyDaoImpl;
import model.Address;
import model.Company;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AddressIOServiceImpl {
    public static void createAddressFromFile(SessionFactory sessionFactory) {
        AddressDaoImpl addressDao = new AddressDaoImpl();
        Address address = new Address();
        String[] words;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/resource/passengers.txt"))
        ) {
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                line = line.replace("'", "");
                words = line.split(",");

                address.setCountry(words[2]);
                address.setCity(words[3]);

               addressDao.createAddress(address, sessionFactory);
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
