package servlet;

import model.Address;
import model.Company;
import model.Passenger;
import org.json.JSONObject;
import service.impl.CompanyServiceImpl;
import service.impl.PassengerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


@WebServlet(urlPatterns = "/company")
    public class CompanyServlet extends HttpServlet {

    private final CompanyServiceImpl companyService = new CompanyServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();
        String str;
        while ((str = reader.readLine()) != null) {
            stringBuilder.append(str);
        }
        JSONObject jsonObject = new JSONObject(stringBuilder.toString());
        String companyName = jsonObject.getString("company_name");
        String foundingDate = jsonObject.getString("founding_date");

        Company company = new Company(companyName, LocalDate.parse(foundingDate));

        companyService.save(company);
        resp.setContentType("application/json");

        JSONObject object = new JSONObject();
        object.put("company_name", companyName);
        object.put("founding_date", foundingDate);

        PrintWriter writer = resp.getWriter();
        writer.println(object);

        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Company company = companyService.getById(Long.parseLong(id));

        resp.setContentType("application/json");

        JSONObject object = new JSONObject();
        object.put("id",company.getId());
        object.put("company_name",company.getCompanyName());
        object.put("founding_date",company.getFoundingDate());

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
            String companyName = jsonObject.getString("company_name");
            String foundingDate = jsonObject.getString("founding_date");
            String id = jsonObject.getString("id");

            Company company = new Company(companyName, LocalDate.parse(foundingDate));

            companyService.update(Long.parseLong(id),company);
            resp.setContentType("application/json");

            JSONObject object = new JSONObject();
            object.put("company_name", companyName);
            object.put("founding_date", foundingDate);

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
            companyService.delete(Long.parseLong(id));
            resp.setContentType("application/json");

            PrintWriter writer = resp.getWriter();
            writer.println("deleted");
        }
    }
