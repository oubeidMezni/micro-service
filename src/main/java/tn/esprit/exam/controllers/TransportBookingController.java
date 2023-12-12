package tn.esprit.exam.controllers;

import com.example.microservice.entities.TransportBooking;
import com.example.microservice.services.TransportBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class TransportBookingController {

    private final TransportBookingService transportBookingService;

    @Autowired
    public TransportBookingController(TransportBookingService transportBookingService) {
        this.transportBookingService = transportBookingService;
    }

    @GetMapping
    public List<TransportBooking> getAllBookings() {
        return transportBookingService.getAllBookings();
    }

    // Other endpoints for specific CRUD operations
}
