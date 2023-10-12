package tn.esprit.ms_event.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ms_event.Entities.Event;

public interface EventRepository extends JpaRepository<Event,Long> {
}
