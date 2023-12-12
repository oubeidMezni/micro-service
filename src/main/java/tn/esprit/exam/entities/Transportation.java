package tn.esprit.exam.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transportation {

    // Getter and Setter for 'id'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Getter and Setter for 'transportType'
    private String transportType;
    // Getter and Setter for 'departureLocation'
    private String departureLocation;
    // Getter and Setter for 'destination'
    private String destination;
    // Getter and Setter for 'departureTime'
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime departureTime;

    // Getter and Setter for 'arrivalTime'
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime arrivalTime;

    // Getter and Setter for 'capacity'
    private int capacity;
    // Getter and Setter for 'price'
    private double price;
    // Getter and Setter for 'availableSeats'
    private int availableSeats;
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private TransportProvider provider;


    public void setId(Long id) {
        this.id = id;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProvider(TransportProvider provider) {
        this.provider = provider;
    }
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Constructors, additional methods, etc.
}
