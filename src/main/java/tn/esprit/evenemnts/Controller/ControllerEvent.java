package tn.esprit.evenemnts.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import tn.esprit.evenemnts.Entites.Event;
import tn.esprit.evenemnts.Entites.StatistiquesFoyers;
import tn.esprit.evenemnts.Service.IserviceEvent;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/event")

public class ControllerEvent {
@Autowired
    IserviceEvent iserviceEvent;

    @GetMapping("/retrieve-all-Events")
    public List<Event> getChambers() {
        List<Event> listEvents = iserviceEvent.retrieveAllEvents();
        return listEvents;
    }

    @GetMapping("/retrieve-Events/{event-id}")
    public Event retrieveEvent(@PathVariable("event-id") Long idEvent) {
        return iserviceEvent.retrieveEvent(idEvent);
    }

    @PostMapping("/add-event")
    public Event addEvent(@RequestBody Event e) {
        Event ev = iserviceEvent.addEvent(e);
        return ev;
    }

    @DeleteMapping("/remove-event/{event-id}")
    public void removeEvent(@PathVariable("event-id") Long idEvent) {
iserviceEvent.removeEvent(idEvent);    }

    @PutMapping("/update-event")
    public Event updateChambre(@RequestBody Event e) throws Exception {
        Event ee = iserviceEvent.updateEvent(e);
        return ee;
    }
    @GetMapping("/sortedByName")
    public ResponseEntity<List<Event>> getAllFoyersSortedByName() {
        List<Event> foyers = iserviceEvent.getAllFoyersSortedByName();
        return new ResponseEntity<>(foyers, HttpStatus.OK);
    }
    @GetMapping("/statistics")
    public ResponseEntity<StatistiquesFoyers> getFoyersStatistics() {
        StatistiquesFoyers statistiques = iserviceEvent.getFoyersStatistics();
        return new ResponseEntity<>(statistiques, HttpStatus.OK);
    }


}
