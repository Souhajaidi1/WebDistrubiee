package com.example.feedback.controller;

import com.example.feedback.model.Feedback;
import com.example.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService ;

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }

    @GetMapping("/{idFeedback}")
    public Feedback getFeedbackById(@PathVariable Long idFeedback) {
        return feedbackService.getFeedbackById(idFeedback);
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @PutMapping("/{idFeedback}")
    public Feedback updateFeedback(@PathVariable Long idFeedback, @RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(idFeedback, feedback);
    }

    @DeleteMapping("/{idFeedback}")
    public void deleteFeedback(@PathVariable Long idFeedback) {
        feedbackService.deleteFeedback(idFeedback);
    }
}
