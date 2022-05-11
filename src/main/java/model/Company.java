package model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "company_name",nullable = false,length = 50)
    private String companyName;
    @Column(name = "founding_date",nullable = false)
    private LocalDate foundingDate;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Trip> trips = new ArrayList<>();

    public Company() {

    }

    public Company( String companyName, LocalDate foundingDate) {

        this.companyName = companyName;
        this.foundingDate = foundingDate;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(LocalDate foundingDate) {
        this.foundingDate = foundingDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id && Objects.equals(companyName, company.companyName)
                && Objects.equals(foundingDate, company.foundingDate) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName,
                foundingDate);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", foundingDate=" + foundingDate +
              //  ", trips=" + trips +
                '}';
    }
}
