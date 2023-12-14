package tn.esprit.evenemnts.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.esprit.evenemnts.Entites.Event;

import java.util.List;

@FeignClient(name = "micro-service-event") // The name of the microservice to communicate with
public interface EventServiceClient {
    @GetMapping("/api/events") // Define the endpoint and method
    List<Event> getEvents() ; // Define the method signature
}
