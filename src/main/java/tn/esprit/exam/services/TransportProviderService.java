package tn.esprit.exam.services;

import com.example.microservice.entities.TransportProvider;
import com.example.microservice.repository.TransportProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportProviderService {

    private final TransportProviderRepository transportProviderRepository;

    @Autowired
    public TransportProviderService(TransportProviderRepository transportProviderRepository) {
        this.transportProviderRepository = transportProviderRepository;
    }

    public List<TransportProvider> getAllProviders() {
        return transportProviderRepository.findAll();
    }

    // Other service methods for CRUD operations, business logic, etc.
}
