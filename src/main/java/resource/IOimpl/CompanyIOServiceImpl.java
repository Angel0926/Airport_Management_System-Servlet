package resource.IOimpl;

import dao.impl.CompanyDaoImpl;
import model.Company;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class CompanyIOServiceImpl {

    private  SessionFactory sessionFactory;


    public CompanyIOServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
   
    public  void createCompanyFromFile() {
        CompanyDaoImpl companyDao=new CompanyDaoImpl(sessionFactory);
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
                Company company = new Company();
                line = line.replace("'", "");
                words = line.split(",");

                company.setCompanyName(words[0]);
                company.setFoundingDate(LocalDate.parse(words[1], DateTimeFormatter.ofPattern("M/d/yyyy")));

                companyDao.createCompany(company);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
