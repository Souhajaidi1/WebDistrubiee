package tn.esprit.ms_event.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ms_event.Entities.Event;
import tn.esprit.ms_event.Entities.User;
import tn.esprit.ms_event.Services.EventServiceIMP;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventServiceIMP eventService;

    @Autowired
    public EventController(EventServiceIMP eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PutMapping("/{eventId}")
    public Event updateEvent(@PathVariable Long eventId, @RequestBody Event event) {
        return eventService.updateEvent(eventId, event);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
    }
    @PostMapping("/{eventId}/register")
    public Event registerForEvent(@PathVariable Long eventId, @RequestBody User user) {return eventService.registerUserForEvent(eventId,user);
    }

    @DeleteMapping("/{eventId}/unregister")
    public Event unregisterFromEvent(@PathVariable Long eventId, @RequestBody User user) { return eventService.unregisterUserFromEvent(eventId,user);

    }
}
