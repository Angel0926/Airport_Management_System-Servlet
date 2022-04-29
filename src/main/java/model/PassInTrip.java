package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table(name = "pass_in_trip",uniqueConstraints = {
        @UniqueConstraint(name = "unique_tripid_psgid", columnNames = {"idTrip", "idPsg"})})
public class PassInTrip {
    @Column(name = "id_trip",nullable = false)
    private long idTrip;
    @Column(name = "id_psg",nullable = false)
    private long idPsg;
    @Column(name = "date",nullable = false)
    private LocalDate date;
    @Column(name = "id_trip",nullable = false,length = 50)
    private String place;
   // Trip trip;
  //  Passenger passenger;

    public PassInTrip() {

    }


}
