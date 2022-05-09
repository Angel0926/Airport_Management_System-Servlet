package resource.IOimpl;

import dao.impl.AddressDaoImpl;
import model.Address;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class AddressIOServiceImpl {


    public  Set<Address> createAddressFromFile() {

        Set<Address> add1 = null;
        Address address = null;
        String[] words;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/resource/passengers.txt"))
        ) {
            add1 = new HashSet<>();
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                line = line.replace("'", "");
                words = line.split(",");
                address = new Address();
                address.setCountry(words[2]);
                address.setCity(words[3]);

                add1.add(address);


                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return add1;
    }
}
