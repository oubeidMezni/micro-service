package tn.esprit.evenemnts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.evenemnts.Entites.Event;

import java.util.List;

@Repository
public interface RepositoryEvent extends JpaRepository<Event,Long> {
    @Query("SELECT f FROM Event f ORDER BY f.nomEvent")
    List<Event> findAllSortedByName();
    @Query("SELECT AVG(f.prix) FROM Event f")
    Double calculateAveragePrix();

    @Query("SELECT MAX(f.prix) FROM Event f")
    Long findMaxPrix();
}
