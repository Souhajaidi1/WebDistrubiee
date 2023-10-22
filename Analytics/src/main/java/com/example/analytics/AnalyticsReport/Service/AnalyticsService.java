package com.example.analytics.AnalyticsReport.Service;

import com.example.analytics.AnalyticsReport.Model.Analytics;
//import com.example.analytics.AnalyticsReport.Model.User;

import java.time.LocalDate;
import java.util.List;

public interface AnalyticsService {


    Analytics createAnalytics(Analytics analytics);

    Analytics getAnalyticsById(Long idReport);

    List<Analytics> getAllAnalytics();

    Analytics updateAnalytics(Long idReport, Analytics analytics);

    void deleteAnalytics(Long idReport);

    List<Analytics> getReportsByDateRange(LocalDate startDate, LocalDate endDate);

    //List<User> getMostActiveUsers();
}
