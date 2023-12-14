package tn.esprit.exam.controllers;

import tn.esprit.evenemnts.Entites.Event;
import tn.esprit.exam.entities.Transportation;
import tn.esprit.exam.services.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/transportations")
public class TransportationController {
    @Autowired
    private TransportationService transportationService;

    @GetMapping
    public List<Transportation> getAllTransportations() {
        return transportationService.getAllTransportations();
    }

  /**  @GetMapping("/getevents")
    public List<Event> getEvents(){
        return transportationService.getEvents();
    }**/
    @GetMapping("/{id}")
    public Transportation getTransportationById(@PathVariable Long id) {
        return transportationService.getTransportationById(id);
    }

    @PostMapping
    public Transportation createTransportation(@RequestBody Transportation transportation) {
        return transportationService.createTransportation(transportation);
    }

    @DeleteMapping("/{id}")
    public void deleteTransportation(@PathVariable Long id) {
        transportationService.deleteTransportation(id);
    }

    // Other endpoints for update, search, etc.
}
