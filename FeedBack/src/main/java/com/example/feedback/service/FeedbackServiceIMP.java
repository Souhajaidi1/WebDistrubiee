package com.example.feedback.service;

import com.example.feedback.model.Feedback;
import com.example.feedback.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceIMP implements FeedbackService{
    @Autowired
     private FeedbackRepository feedbackRepository;
    @Override
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback getFeedbackById(Long idFeedback) {
        Optional<Feedback> optionalFeedback = feedbackRepository.findById(idFeedback);
        return optionalFeedback.orElse(null);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback updateFeedback(Long idFeedback, Feedback feedback) {
        if (feedbackRepository.existsById(idFeedback)) {
            feedback.setId(idFeedback);
            return feedbackRepository.save(feedback);
        }
        return null;
    }

    @Override
    public void deleteFeedback(Long idFeedback) {
        feedbackRepository.deleteById(idFeedback);
    }

}
