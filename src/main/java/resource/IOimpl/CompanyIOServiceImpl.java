package resource.IOimpl;

import model.Company;
import service.impl.CompanyServiceImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class CompanyIOServiceImpl {


    private final CompanyServiceImpl companyService = new CompanyServiceImpl();
   
    public  void createCompanyFromFile() {

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

                companyService.save(company);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
