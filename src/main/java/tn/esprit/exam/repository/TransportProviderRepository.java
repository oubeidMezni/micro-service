package tn.esprit.exam.repository;

import tn.esprit.exam.entities.TransportProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportProviderRepository extends JpaRepository<TransportProvider, Integer> {
    // Custom query methods, if needed
}
