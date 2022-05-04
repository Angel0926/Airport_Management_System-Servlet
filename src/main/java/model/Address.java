package model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "address", uniqueConstraints =
@UniqueConstraint(columnNames = {"Country", "City"}))
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CountrY", nullable = false, length = 50)
    private String country;
    @Column(name = "CitY", nullable = false, length = 50)
    private String city;

    @OneToMany(mappedBy = "address",cascade = {CascadeType.PERSIST, CascadeType.ALL})
    private Set<Passenger> passengers = new HashSet<>();


    public Address() {

    }

    public Address(String country, String city) {
        this.id = id;
        this.country = country;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && Objects.equals(country, address.country) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                "}\n";
    }
}
