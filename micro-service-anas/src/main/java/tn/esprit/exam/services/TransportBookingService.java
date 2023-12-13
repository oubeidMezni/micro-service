package tn.esprit.exam.services;

import tn.esprit.exam.entities.TransportBooking;
import tn.esprit.exam.repository.TransportBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportBookingService {

    private final TransportBookingRepository transportBookingRepository;

    @Autowired
    public TransportBookingService(TransportBookingRepository transportBookingRepository) {
        this.transportBookingRepository = transportBookingRepository;
    }

    public List<TransportBooking> getAllBookings() {
        return transportBookingRepository.findAll();
    }

    // Other service methods for CRUD operations, business logic, etc.
}
