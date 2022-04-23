package resource.IOimpl;

import dao.impl.AddressDaoImpl;
import model.Address;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AddressIOimpl {

    public static void getAddressFromFile() {

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

                addressDao.createAddress(address);
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


