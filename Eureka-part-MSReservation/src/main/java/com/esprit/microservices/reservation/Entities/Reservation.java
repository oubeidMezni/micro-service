package com.esprit.microservices.reservation.Entities;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue
    private long idReservation;
    private ReservationType Rtype;
    private String Location;
    private LocalDateTime reservationDateTime;

    public Reservation() {
    }

    public Reservation(ReservationType rtype, String location, LocalDateTime reservationDateTime) {
        Rtype = rtype;
        Location = location;
        this.reservationDateTime = reservationDateTime;
    }

    public void setReservationDateTime(LocalDateTime reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }
}
