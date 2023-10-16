package tn.esprit.msreunion.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msreunion.Entities.Reunion;

import java.util.Date;
import java.util.List;

public interface ReunionRepository extends JpaRepository<Reunion, Long> {
    List<Reunion>findByAgendaContainingIgnoreCase(String keyword);
   // List<Reunion>findUpcomingReunions(Date currentdate);
}
