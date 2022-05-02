package resource.IOimpl;


import dao.AddressDao;
import dao.impl.AddressDaoImpl;
import dao.impl.PassengerDaoImpl;

import model.Address;
import model.Passenger;
import org.hibernate.SessionFactory;

import java.io.*;
import java.util.HashSet;
import java.util.Set;


public class PassengerIOServiceImpl {

    public static void createPassengerFromFile(SessionFactory sessionFactory) {
Set<Address> setadd=AddressIOServiceImpl.createAddressFromFile(sessionFactory);
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
            AddressDao addressDao=new AddressDaoImpl();





            words = line.split(",");
            for (int i = 0; i < words.length; i++) {
                System.out.print(words[i] + " ");
                passenger.setName(words[0]);
                passenger.setPhone(words[1]);
                Address address = new Address();
                address.setCountry(words[2]);
                address.setCity(words[3]);
                for (Address address1 : setadd) {
                    if(address1.equals(address)){
                        passenger.setAddress(address1);
                        passengerDao.createPassenger(passenger, sessionFactory);
                        break;
                    }
                }

            }


        }
        try {
            System.out.println();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
