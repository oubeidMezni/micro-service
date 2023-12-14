package tn.esprit.exam.services;




import tn.esprit.evenemnts.Entites.Event;
import tn.esprit.evenemnts.Service.EventServiceClient;
import tn.esprit.exam.entities.Transportation;
import tn.esprit.exam.repository.TransportationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportationService {

    @Autowired
    private TransportationRepository transportationRepository;


    /**@Autowired
     private  EventServiceClient eventServiceClient;

     public List<Event> getEvents(){
         return eventServiceClient.getEvents();
     }**/
    public List<Transportation> getAllTransportations() {

        return transportationRepository.findAll();
    }

    public Transportation getTransportationById(Long id) {
        return transportationRepository.findById(id).orElse(null);
    }

    public Transportation createTransportation(Transportation transportation) {
        return transportationRepository.save(transportation);
    }

    public void deleteTransportation(Long id) {
        transportationRepository.deleteById(id);
    }

    // Other methods for update, search, etc.
}
