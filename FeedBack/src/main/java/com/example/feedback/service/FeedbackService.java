package com.example.feedback.service;

import com.example.feedback.exception.BadWordException;
import com.example.feedback.model.Feedback;

import java.io.IOException;
import java.util.List;

public  interface FeedbackService {
    Feedback createFeedback(Feedback feedback) throws IOException, BadWordException;

    Feedback getFeedbackById(Long idFeedback);

    List<Feedback> getAllFeedback();

    Feedback updateFeedback(Long idFeedback, Feedback feedback);

    void deleteFeedback(Long idFeedback);


}
