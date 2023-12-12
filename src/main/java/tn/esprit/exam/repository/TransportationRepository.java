package tn.esprit.exam.repository;

import com.example.microservice.entities.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportationRepository extends JpaRepository<Transportation, Long> {
    // Add custom query methods if needed
}