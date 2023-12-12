package tn.esprit.exam.repository;

import com.example.microservice.entities.TransportBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportBookingRepository extends JpaRepository<TransportBooking, Integer> {
    // Custom query methods, if needed
}
