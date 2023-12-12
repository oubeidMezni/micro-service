package tn.esprit.exam.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TransportProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int providerId;
    private String name;
    private String contactDetails;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Transportation> servicesOffered;

    // Constructors, Getters, and Setters
    public TransportProvider() {
    }

    // Constructor with fields
    public TransportProvider(int providerId, String name, String contactDetails, List<Transportation> servicesOffered) {
        this.providerId = providerId;
        this.name = name;
        this.contactDetails = contactDetails;
        this.servicesOffered = servicesOffered;
    }

    // Getters and Setters
    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public List<Transportation> getServicesOffered() {
        return servicesOffered;
    }

    public void setServicesOffered(List<Transportation> servicesOffered) {
        this.servicesOffered = servicesOffered;
    }

    // Additional methods, if needed
}
