package com.esprit.microservices.reservation.Controller;

import com.esprit.microservices.reservation.Entities.Reservation;
import com.esprit.microservices.reservation.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/reservations")
@RestController
public class ReservationRestAPI {
    private String title="Hello, i'm the reservation Micro-Service";
    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println(title);
        return title;
    }
    @Autowired
    private ReservationService reservationService;
    @PostMapping( value= "/add" , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.addReservation(reservation), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reservation> updateReservation(@PathVariable(value = "id") Long id,
                                                         @RequestBody Reservation reservation){
        return new ResponseEntity<>(reservationService.updateResrevation(id, reservation),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteReservation(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(reservationService.removeReservation(id), HttpStatus.OK);
    }
    @GetMapping(value ="", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Reservation>> retrieveAllReservation() {
        List<Reservation> reservations = reservationService.retireveAllReservations();
        if (reservations != null && !reservations.isEmpty()) {
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
