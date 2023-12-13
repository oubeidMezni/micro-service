package com.esprit.microservices.reservation;

import com.esprit.microservices.reservation.Entities.Reservation;
import com.esprit.microservices.reservation.Entities.ReservationType;
import com.esprit.microservices.reservation.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


import java.time.LocalDateTime;

@SpringBootApplication
@EnableEurekaClient
public class ReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
    }
    @Autowired
    private ReservationRepository reservationRepository;
    LocalDateTime currentDateTime = LocalDateTime.now();

    @Bean
    ApplicationRunner init() {
        return (args) -> {
// save
            reservationRepository.save(new Reservation( ReservationType.pending, "nabeul",currentDateTime));
            reservationRepository.save(new Reservation( ReservationType.canceled, "sousse",currentDateTime));
            reservationRepository.save(new Reservation( ReservationType.confirmed, "bizerte",currentDateTime));
// fetch
            reservationRepository.findAll().forEach(System.out::println);
        };
    }
}
