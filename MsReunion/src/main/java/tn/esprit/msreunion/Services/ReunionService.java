package tn.esprit.msreunion.Services;

import tn.esprit.msreunion.Entities.Reunion;
import tn.esprit.msreunion.Entities.User;

import java.util.List;

public interface ReunionService {
    Reunion createReunion(Reunion reunion);
    Reunion getReunionById(Long reunionId);
    List<Reunion> getAllReunions();
    Reunion updateReunion(Long reunionId, Reunion reunion);
    void deleteReunion(Long reunionId);
    List<Reunion> searchReunionsByKeyword(String keyword);
    List<User> getAttendeesForReunion(Long reunionId);

    Reunion assignAttendees(Long reunionId, List<User> attendees);

    Reunion removeAttendees(Long reunionId, List<User> attendees);

   // List<Reunion> getUpcomingReunions();
}
