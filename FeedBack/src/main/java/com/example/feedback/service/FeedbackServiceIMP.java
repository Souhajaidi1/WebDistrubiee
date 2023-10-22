package com.example.feedback.service;

import com.example.feedback.exception.BadWordException;
import com.example.feedback.helpers.BadWordFilter;
import com.example.feedback.model.Feedback;
import com.example.feedback.repository.FeedbackRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public  class FeedbackServiceIMP implements FeedbackService{
    @Autowired
     private FeedbackRepository feedbackRepository;
    @Autowired
    private  BadWordFilter badWordFilter;


    @Override
    public Feedback createFeedback(Feedback feedback) throws IOException, BadWordException {
        if (badWordFilter.checkBadWord(feedback.getDescription()))
            throw new BadWordException("Bad word detected");
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
        feedback.setIdFeedback(idFeedback);
        return feedbackRepository.save(feedback);
    }
    @Override
    public void deleteFeedback(Long idFeedback) {
        feedbackRepository.deleteById(idFeedback);
    }




}
