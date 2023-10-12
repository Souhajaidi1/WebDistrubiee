package tn.esprit.ms_event.Services;

import tn.esprit.ms_event.Entities.Event;

import java.util.List;

public interface IEventService {
    Event createEvent(Event event);
    Event getEventById(Long eventId);
    List<Event> getAllEvents();
    Event updateEvent(Long eventId, Event event);
    void deleteEvent(Long eventId);
}
