package model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "trip")
public class Trip implements Serializable {
    @Id
    private long id;

    @Column(name = "plane", nullable = false, length = 50)
    private String plane;
    @Column(name = "town_from", nullable = false, length = 50)
    private String townFrom;
    @Column(name = "town_to", nullable = false, length = 50)
    private String townTo;
    @Column(name = "time_out", nullable = false)
    private LocalTime timeOut;
    @Column(name = "time_in", nullable = false)
    private LocalTime timeIn;


    @JoinColumn(name = "id_company", foreignKey = @ForeignKey(name = "company_trip_fk"))
    private Long id_company;

    @ManyToMany(mappedBy = "trips")
    private Set<Passenger> passengers = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Pass_In_Trip",
            joinColumns = {@JoinColumn(name = "id_psg")},
            inverseJoinColumns = {@JoinColumn(name = "id_trip")}
    )
    private Set<Passenger> passenger = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getTownFrom() {
        return townFrom;
    }

    public void setTownFrom(String townFrom) {
        this.townFrom = townFrom;
    }

    public String getTownTo() {
        return townTo;
    }

    public void setTownTo(String townTo) {
        this.townTo = townTo;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public Long getId_company() {
        return id_company;
    }

    public void setId_company(Long id_company) {
        this.id_company = id_company;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Set<Passenger> getPassenger() {
        return passenger;
    }

    public void setPassenger(Set<Passenger> passenger) {
        this.passenger = passenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return id == trip.id && Objects.equals(plane, trip.plane) && Objects.equals(townFrom, trip.townFrom) && Objects.equals(townTo, trip.townTo) && Objects.equals(timeOut, trip.timeOut) && Objects.equals(timeIn, trip.timeIn) && Objects.equals(id_company, trip.id_company) && Objects.equals(passengers, trip.passengers) && Objects.equals(passenger, trip.passenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plane, townFrom, townTo, timeOut, timeIn, id_company, passengers, passenger);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", plane='" + plane + '\'' +
                ", townFrom='" + townFrom + '\'' +
                ", townTo='" + townTo + '\'' +
                ", timeOut=" + timeOut +
                ", timeIn=" + timeIn +
                ", id_company=" + id_company +
                ", passengers=" + passengers +
                ", passenger=" + passenger +
                '}';
    }
}
