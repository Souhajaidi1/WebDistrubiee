package tn.esprit.msreunion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.msreunion.Entities.Reunion;
import tn.esprit.msreunion.Entities.User;
import tn.esprit.msreunion.Services.ReunionService;

import java.util.List;

@RestController
@RequestMapping("/reunions")
public class ReunionController {
    private ReunionService reunionService;

    @Autowired
    public ReunionController(ReunionService reunionService) {
        this.reunionService = reunionService;
    }

    @PostMapping
    public Reunion createReunion(@RequestBody Reunion reunion) {
        return reunionService.createReunion(reunion);
    }

    @GetMapping("retrieve/{reunionId}")
    public Reunion getReunionById(@PathVariable Long reunionId) {
        return reunionService.getReunionById(reunionId);
    }

    @GetMapping("/retrieveall")
    public List<Reunion> getAllReunions() {
        return reunionService.getAllReunions();
    }

    @PutMapping("update/{reunionId}")
    public Reunion updateReunion(@PathVariable Long reunionId, @RequestBody Reunion reunion) {
        return reunionService.updateReunion(reunionId, reunion);
    }

    @DeleteMapping("delete/{reunionId}")
    public void deleteReunion(@PathVariable Long reunionId) {
        reunionService.deleteReunion(reunionId);
    }

    @GetMapping("/search")
    public List<Reunion> searchReunionsByKeyword(@RequestParam(name = "keyword") String keyword) {
        return reunionService.searchReunionsByKeyword(keyword);
    }

    @GetMapping("attendees/{reunionId}")
    public List<User> getAttendeesForReunion(@PathVariable Long reunionId) {
        return reunionService.getAttendeesForReunion(reunionId);
    }
    @PutMapping("/{reunionId}/assign-attendees")
    public Reunion assignAttendees(@PathVariable Long reunionId, @RequestBody List<User> attendees) {
        return reunionService.assignAttendees(reunionId, attendees);
    }

    @PutMapping("/{reunionId}/remove-attendees")
    public Reunion removeAttendees(@PathVariable Long reunionId, @RequestBody List<User> attendees) {
        return reunionService.removeAttendees(reunionId, attendees);
    }
   /* @GetMapping("/upcoming")
    public List<Reunion> getUpcomingReunions() {
        return reunionService.getUpcomingReunions();
    }*/


}

