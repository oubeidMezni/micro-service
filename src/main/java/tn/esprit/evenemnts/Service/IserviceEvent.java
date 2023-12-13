package tn.esprit.evenemnts.Service;

import tn.esprit.evenemnts.Entites.Event;
import tn.esprit.evenemnts.Entites.StatistiquesFoyers;

import java.util.List;

public interface IserviceEvent {
Event addEvent(Event event);
    Event updateEvent(Event e) throws Exception;

    Event retrieveEvent(Long idEvent);

    void removeEvent(Long idEvent);
    List<Event> retrieveAllEvents();
     StatistiquesFoyers getFoyersStatistics();
     List<Event> getAllFoyersSortedByName() ;

}
