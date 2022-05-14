package servlet.passengerServlet;


import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PassengerServlet extends HttpServlet {

    private final PassengerServiceImpl passengerService = new PassengerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();
        String str;
        while ((str = reader.readLine()) != null){
            stringBuilder.append(str);
        }
        JSONObject jsonObject = new JSONObject(stringBuilder.toString());
        String name = jsonObject.getString("name");
        String phone = jsonObject.getString("phone");
        String country = jsonObject.getString("country");
        String city = jsonObject.getString("city");

        Address address = new Address(country,city);

        Passenger passenger = new Passenger(name,phone);
        passenger.setAddress(address);

        log.info("request to save a passenger");

        passengerService.save(passenger);

        log.info("passenger {} was created",name);

        resp.setContentType("application/json");

        JSONObject object = new JSONObject();
        object.put("name",name);
        object.put("phone",phone);
        object.put("country",country);
        object.put("city",city);

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
        object.put("id",passenger.getId());
        object.put("name",passenger.getName());
        object.put("phone",passenger.getPhone());
        object.put("country",passenger.getAddress().getCountry());
        object.put("city",passenger.getAddress().getCity());

        PrintWriter writer = resp.getWriter();
        writer.println(object);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name1");
        String phone = req.getParameter("phone1");
        String country = req.getParameter("country1");
        String city = req.getParameter("city1");


        Address address = new Address(country, city);
        Passenger passenger = new Passenger(name, phone);
        passenger.setAddress(address);
        String id1 = req.getParameter("id1");

        passengerService.update(Long.parseLong(id1), passenger);


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        passengerService.delete(Long.parseLong(id));
    }
}
