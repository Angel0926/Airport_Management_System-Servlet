package servlet;


import dao.impl.AddressDaoImpl;
import model.Address;
import model.Passenger;
import org.json.JSONObject;
import service.impl.PassengerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/passenger")
public class PassengerServlet extends HttpServlet {

    private final PassengerServiceImpl passengerService = new PassengerServiceImpl();
    private final AddressDaoImpl addressDao = new AddressDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();
        String str;
        while ((str = reader.readLine()) != null) {
            stringBuilder.append(str);
        }
        JSONObject jsonObject = new JSONObject(stringBuilder.toString());
        String name = jsonObject.getString("name");
        String phone = jsonObject.getString("phone");
        String country = jsonObject.getString("country");
        String city = jsonObject.getString("city");

        Address address = new Address(country, city);
        addressDao.createAddress(address);
        Passenger passenger = new Passenger(name, phone);
        passenger.setAddress(address);
        passengerService.save(passenger);


        resp.setContentType("application/json");

        JSONObject object = new JSONObject();
        object.put("name", name);
        object.put("phone", phone);
        object.put("country", country);
        object.put("city", city);

        PrintWriter writer = resp.getWriter();
        writer.println(object);

        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Passenger passenger = passengerService.getById(Long.parseLong(id));

        resp.setContentType("application/json");

        JSONObject object = new JSONObject();
        object.put("id", passenger.getId());
        object.put("name", passenger.getName());
        object.put("phone", passenger.getPhone());
        object.put("country", passenger.getAddress().getCountry());
        object.put("city", passenger.getAddress().getCity());

        PrintWriter writer = resp.getWriter();
        writer.println(object);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();
        String str;
        while ((str = reader.readLine()) != null) {
            stringBuilder.append(str);
        }
        JSONObject jsonObject = new JSONObject(stringBuilder.toString());
        String name = jsonObject.getString("name");
        String phone = jsonObject.getString("phone");
        String country = jsonObject.getString("country");
        String city = jsonObject.getString("city");
        String id = jsonObject.getString("id");//
        Address address = new Address(country, city);

        Passenger passenger = new Passenger(name, phone);
        passenger.setAddress(address);

        passengerService.update(Long.parseLong(id), passenger);

        resp.setContentType("application/json");

        JSONObject object = new JSONObject();
        object.put("name", name);
        object.put("phone", phone);
        object.put("country", country);
        object.put("city", city);
        PrintWriter writer = resp.getWriter();
        writer.println(object);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();
        String str;
        while ((str = reader.readLine()) != null) {
            stringBuilder.append(str);
        }
        JSONObject jsonObject = new JSONObject(stringBuilder.toString());
        String id = jsonObject.getString("id");
        passengerService.delete(Long.parseLong(id));
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        writer.println("deleted");
    }
}
