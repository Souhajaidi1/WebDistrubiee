package tn.esprit.ms_event.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ms_event.Entities.Event;
import tn.esprit.ms_event.Entities.User;
import tn.esprit.ms_event.Repositories.EventRepository;
import tn.esprit.ms_event.Repositories.UserRepository;

import java.util.List;
import java.util.Set;

@Service
public class EventServiceIMP implements IEventService {
    @Autowired
        private  EventRepository eventRepository;
        private  UserRepository userRepository;


        @Override
        public Event createEvent(Event event) {
            return eventRepository.save(event);
        }

        @Override
        public Event getEventById(Long eventId) {
            return eventRepository.findById(eventId).orElse(null);
        }

        @Override
        public List<Event> getAllEvents() {
            return eventRepository.findAll();
        }

        @Override
        public Event updateEvent(Long eventId, Event event) {
            event.setEventId(eventId);
            return eventRepository.save(event);
        }

        @Override
        public void deleteEvent(Long eventId) {
            eventRepository.deleteById(eventId);
        }
    @Override
    public Event registerUserForEvent(Long eventId, User user) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            Set<User> registeredUsers = event.getRegisteredUsers();
            registeredUsers.add(user);
            event.setRegisteredUsers(registeredUsers);
            return eventRepository.save(event);
        }
        return null; // Handle error if event doesn't exist
    }

    @Override
    public Event unregisterUserFromEvent(Long eventId, User user) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            Set<User> registeredUsers = event.getRegisteredUsers();
            registeredUsers.remove(user);
            event.setRegisteredUsers(registeredUsers);
            return eventRepository.save(event);
        }
        return null; 
    }

}


