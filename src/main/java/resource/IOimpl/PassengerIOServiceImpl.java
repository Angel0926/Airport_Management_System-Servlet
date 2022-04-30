package resource.IOimpl;


import dao.impl.PassengerDaoImpl;

import model.Address;
import model.Passenger;
import org.hibernate.SessionFactory;

import java.io.*;



public class PassengerIOServiceImpl {

    public static void createPassengerFromFile(SessionFactory sessionFactory) {

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
            Address address = new Address();


            words = line.split(",");
            for (int i = 0; i < words.length; i++) {
                System.out.print(words[i] + " ");
                passenger.setName(words[0]);
                passenger.setPhone(words[1]);
                address.setCountry(words[2]);
                address.setCity(words[3]);
                passenger.setAddress(address);
            }
            passengerDao.createPassenger(passenger, sessionFactory);

        }
        try {
            System.out.println();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
