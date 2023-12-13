package tn.esprit.exam.repository;

import tn.esprit.exam.entities.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportationRepository extends JpaRepository<Transportation, Long> {
    // Add custom query methods if needed
}