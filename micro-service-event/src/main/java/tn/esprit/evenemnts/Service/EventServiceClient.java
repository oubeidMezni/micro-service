package tn.esprit.evenemnts.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.esprit.evenemnts.Entites.Event;

import java.util.List;

@FeignClient(name = "EVENT-S") // The name of the microservice to communicate with
public interface EventServiceClient {
    @GetMapping("/api/events") // Define the endpoint and method
    List<Event> getEvents() ; // Define the method signature
}
