package tn.esprit.evenemnts.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.evenemnts.Entites.Event;
import tn.esprit.evenemnts.Entites.StatistiquesFoyers;
import tn.esprit.evenemnts.Repository.RepositoryEvent;

import java.util.List;

@Service
public class ServiceEvent  implements IserviceEvent{
    @Autowired
    RepositoryEvent repositoryEvent;
    public Event addEvent(Event event){
Event e= repositoryEvent.save(event);
return e;
    }
   public Event updateEvent(Event e) throws Exception{
        Event ee= repositoryEvent.save(e);
        return ee;

   }

   public Event retrieveEvent(Long idEvent){
        Event ev=repositoryEvent.findById(idEvent).get();
        return ev;

   }

   public void removeEvent(Long idEvent){

         repositoryEvent.deleteById(idEvent);
   }
    public List<Event> retrieveAllEvents(){
      return  repositoryEvent.findAll();
    }
    public List<Event> getAllFoyersSortedByName() {
        return repositoryEvent.findAllSortedByName();
    }

    public StatistiquesFoyers getFoyersStatistics() {
        Double averagePrix = repositoryEvent.calculateAveragePrix();
        Long maxPrix = repositoryEvent.findMaxPrix();

        return new StatistiquesFoyers(averagePrix, maxPrix);
    }

}
