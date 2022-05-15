package servlet;


import model.Company;
import model.Trip;
import org.json.JSONObject;
import service.impl.CompanyServiceImpl;
import service.impl.TripServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;


@WebServlet(urlPatterns = "/trip")
public class TripServlet extends HttpServlet {

    private final TripServiceImpl tripService = new TripServiceImpl();
    private  final CompanyServiceImpl companyService=new CompanyServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();
        String str;
        while ((str = reader.readLine()) != null) {
            stringBuilder.append(str);
        }
        JSONObject jsonObject = new JSONObject(stringBuilder.toString());
        String plane = jsonObject.getString("plane");
        String townFrom = jsonObject.getString("town_from");
        String townTo = jsonObject.getString("town_to");
        String timeIn = jsonObject.getString("time_in");
        String timeOut = jsonObject.getString("time_out");
        String id = jsonObject.getString("id");

        Company company = companyService.getById(Long.parseLong(id));
        Trip trip = new Trip(plane, townFrom, townTo, LocalTime.parse(timeIn), LocalTime.parse(timeOut));


        trip.setCompany(company);

        tripService.save(trip);
        resp.setContentType("application/json");

        JSONObject object = new JSONObject();
        object.put("plane", plane);
        object.put("town_from", townFrom);
        object.put("town_to", townTo);
        object.put("time_in", timeIn);
        object.put("time_out", timeOut);
        object.put("id", id);


        PrintWriter writer = resp.getWriter();
        writer.println(object);

        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Trip trip = tripService.getById(Long.parseLong(id));

        resp.setContentType("application/json");

        JSONObject object = new JSONObject();
        object.put("id",trip.getId());
        object.put("town_from",trip.getTownFrom());
        object.put("town_to",trip.getTownTo());
        object.put("time_in",trip.getTimeIn());
        object.put("time_out",trip.getTimeOut());
        object.put("id_company",trip.getCompany().getId());

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
        String plane = jsonObject.getString("plane");
        String townFrom = jsonObject.getString("town_from");
        String townTo = jsonObject.getString("town_to");
        String timeIn = jsonObject.getString("time_in");
        String timeOut = jsonObject.getString("time_out");
        String id = jsonObject.getString("id");
        String idUpdate = jsonObject.getString("id_update");

        Company company = companyService.getById(Long.parseLong(id));
        Trip trip = new Trip(plane, townFrom, townTo, LocalTime.parse(timeIn), LocalTime.parse(timeOut));


        trip.setCompany(company);

       tripService.update(Long.parseLong(idUpdate),trip);

        resp.setContentType("application/json");

        JSONObject object = new JSONObject();
        object.put("plane", plane);
        object.put("town_from", townFrom);
        object.put("town_to", townTo);
        object.put("time_in", timeIn);
        object.put("time_out", timeOut);
        object.put("id", id);


        PrintWriter writer = resp.getWriter();
        writer.println(object);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();
        String str;
        while ((str = reader.readLine()) != null){
            stringBuilder.append(str);
        }
        JSONObject jsonObject = new JSONObject(stringBuilder.toString());
        String id = jsonObject.getString("id");
        tripService.delete(Long.parseLong(id));
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        writer.println("deleted");
    }
}
