package tn.esprit.exam.controllers;

import tn.esprit.exam.entities.TransportProvider;
import tn.esprit.exam.services.TransportProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class TransportProviderController {

    private final TransportProviderService transportProviderService;

    @Autowired
    public TransportProviderController(TransportProviderService transportProviderService) {
        this.transportProviderService = transportProviderService;
    }

    @GetMapping
    public List<TransportProvider> getAllProviders() {
        return transportProviderService.getAllProviders();
    }

    // Other endpoints for specific CRUD operations
}

