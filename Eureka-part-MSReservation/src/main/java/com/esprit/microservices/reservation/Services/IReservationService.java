package com.esprit.microservices.reservation.Services;

import com.esprit.microservices.reservation.Entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retireveAllReservations();
    Reservation addReservation(Reservation e);

    Reservation updateResrevation(Long id,Reservation R);

    Reservation retrieveReservation(Long idReservation);
    String removeReservation(Long id);

}
