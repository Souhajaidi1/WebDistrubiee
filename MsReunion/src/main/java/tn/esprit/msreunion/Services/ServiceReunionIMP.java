package tn.esprit.msreunion.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.msreunion.Entities.Reunion;
import tn.esprit.msreunion.Entities.User;
import tn.esprit.msreunion.Repositories.ReunionRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ServiceReunionIMP implements ReunionService {
    @Autowired
    private  ReunionRepository reunionRepository;

    @Override
    public Reunion createReunion(Reunion reunion) {
        return reunionRepository.save(reunion);
    }

    @Override
    public Reunion getReunionById(Long reunionId) {
        return reunionRepository.findById(reunionId).orElse(null);
    }

    @Override
    public List<Reunion> getAllReunions() {
        return reunionRepository.findAll();
    }

    @Override
    public Reunion updateReunion(Long reunionId, Reunion reunion) {
        reunion.setReunionId(reunionId);
        return reunionRepository.save(reunion);
    }

    @Override
    public void deleteReunion(Long reunionId) {
        reunionRepository.deleteById(reunionId);
    }

    @Override
    public List<Reunion> searchReunionsByKeyword(String keyword) {
        return reunionRepository.findByAgendaContainingIgnoreCase(keyword);
    }

    @Override
    public List<User> getAttendeesForReunion(Long reunionId) {
        Reunion reunion = reunionRepository.findById(reunionId).orElse(null);
        if (reunion != null) {
            return new ArrayList<>(reunion.getAttendees());
        }
        return null; // Handle error if reunion doesn't exist
    }
    @Override
    public Reunion assignAttendees(Long reunionId, List<User> attendees) {
        Reunion reunion = reunionRepository.findById(reunionId).orElse(null);
        if (reunion != null) {
            Set<User> currentAttendees = reunion.getAttendees();
            currentAttendees.addAll(attendees);
            reunion.setAttendees(currentAttendees);
            return reunionRepository.save(reunion);
        }
        return null; // Handle error if the reunion doesn't exist
    }

    @Override
    public Reunion removeAttendees(Long reunionId, List<User> attendees) {
        Reunion reunion = reunionRepository.findById(reunionId).orElse(null);
        if (reunion != null) {
            Set<User> currentAttendees = reunion.getAttendees();
            currentAttendees.removeAll(attendees);
            reunion.setAttendees(currentAttendees);
            return reunionRepository.save(reunion);
        }
        return null; // Handle error if the reunion doesn't exist
    }
   /* @Override
    public List<Reunion> getUpcomingReunions() {
        // Define a date threshold (e.g., current date and time) to filter upcoming reunions
        Date currentDate = new Date();
        return reunionRepository.findUpcomingReunions(currentDate);
    } */


}

