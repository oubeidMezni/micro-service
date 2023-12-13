package com.esprit.microservices.reservation.Services;

import com.esprit.microservices.reservation.Entities.Reservation;
import com.esprit.microservices.reservation.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService{
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> retireveAllReservations(){
        return reservationRepository.findAll();
    }
    @Override
    public Reservation addReservation(Reservation e){
        return reservationRepository.save(e);
    }
    @Override
    public Reservation updateResrevation( Long id ,Reservation e ){
        if (reservationRepository.findById(id).isPresent()) {
            Reservation existingreservation = reservationRepository.findById(id).get();
            existingreservation.setRtype(e.getRtype());
            existingreservation.setLocation(e.getLocation());
            existingreservation.setReservationDateTime(e.getReservationDateTime());
            return reservationRepository.save(existingreservation);
        } else
            return null;
    }


    @Override
    public String removeReservation(Long id){
        if (reservationRepository.findById(id).isPresent()) {
            reservationRepository.deleteById(id);
            return "reservation supprimé";
        } else
            return "reservation non supprimé";

    }
    @Override
    public Reservation retrieveReservation(Long id){

        return reservationRepository.findById(id).get();
    }

}
