package tn.esprit.exam.services;

import com.example.microservice.entities.Transportation;
import com.example.microservice.repository.TransportationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportationService {
    @Autowired
    private TransportationRepository transportationRepository;

    public List<Transportation> getAllTransportations() {
        return transportationRepository.findAll();
    }

    public Transportation getTransportationById(Long id) {
        return transportationRepository.findById(id).orElse(null);
    }

    public Transportation createTransportation(Transportation transportation) {
        return transportationRepository.save(transportation);
    }

    public void deleteTransportation(Long id) {
        transportationRepository.deleteById(id);
    }

    // Other methods for update, search, etc.
}
