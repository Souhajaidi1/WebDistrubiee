package com.example.feedback.controller;

import com.example.feedback.exception.BadWordException;
import com.example.feedback.model.Feedback;
import com.example.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService ;

    @PostMapping("/feedback")
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        try {
            return feedbackService.createFeedback(feedback);
        } catch (IOException e) {
            // Handle IO exception, if necessary
            e.printStackTrace();
            return null; // You might want to return an appropriate response here
        } catch (BadWordException e) {
            // Handle the bad word exception
            return null; // You might want to return an appropriate response here
        }
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
