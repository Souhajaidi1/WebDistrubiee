package tn.esprit.ms_event.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ms_event.Entities.Event;
import tn.esprit.ms_event.Repositories.EventRepository;

import java.util.List;

@Service
public class EventServiceIMP implements IEventService {
    @Autowired
        private  EventRepository eventRepository;


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
    }


