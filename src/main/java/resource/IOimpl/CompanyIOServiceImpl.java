package resource.IOimpl;

import dao.impl.CompanyDaoImpl;
import model.Company;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class CompanyIOServiceImpl {
    public static void createCompanyFromFile(SessionFactory sessionFactory) {

        CompanyDaoImpl companyDao = new CompanyDaoImpl();
        Company company = new Company();
        String[] words;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/resource/companies.txt"))
        ) {
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                line = line.replace("'", "");
                words = line.split(",");

                company.setCompanyName(words[0]);
                company.setFoundingDate(LocalDate.parse(words[1], DateTimeFormatter.ofPattern("M/d/yyyy")));
companyDao.createCompany(company, sessionFactory);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
