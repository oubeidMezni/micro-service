package tn.esprit.exam.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TransportBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private int userId; // Changed from User user to int userId
    @ManyToOne
    @JoinColumn(name = "transportation_id")
    private Transportation transportation;
    private LocalDateTime bookingDateTime;
    private int numberOfSeatsBooked;

    // Constructors, Getters, and Setters
    // Constructor with fields

    public TransportBooking() {

    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Transportation getTransportationId() {
        return this.transportation;
    }

    public void setTransportationId(Transportation t) {
        this.transportation = t;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public int getNumberOfSeatsBooked() {
        return numberOfSeatsBooked;
    }

    public void setNumberOfSeatsBooked(int numberOfSeatsBooked) {
        this.numberOfSeatsBooked = numberOfSeatsBooked;
    }

    // Additional methods, if needed
}
