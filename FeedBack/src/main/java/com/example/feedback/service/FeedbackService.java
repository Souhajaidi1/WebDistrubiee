package com.example.feedback.service;

import com.example.feedback.model.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback createFeedback(Feedback feedback);

    Feedback getFeedbackById(Long idFeedback);

    List<Feedback> getAllFeedback();

    Feedback updateFeedback(Long idFeedback, Feedback feedback);

    void deleteFeedback(Long idFeedback);
}
