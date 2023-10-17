package com.example.analytics.AnalyticsReport.Service;

import com.example.analytics.AnalyticsReport.Model.Analytics;
import com.example.analytics.AnalyticsReport.Model.User;
import com.example.analytics.AnalyticsReport.Repository.AnalyticsRepository;
import com.example.analytics.AnalyticsReport.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AnalyticsServiceImpl implements AnalyticsService {



    @Autowired
    private AnalyticsRepository analyticsRepository;
    private UserRepository userRepository;

    @Override
    public Analytics createAnalytics(Analytics analytics) {
        return analyticsRepository.save(analytics);
    }

    @Override
    public Analytics getAnalyticsById(Long idReport) {
        Optional<Analytics> optionalAnalytics = analyticsRepository.findById(idReport);
        return optionalAnalytics.orElse(null);
    }

    @Override
    public List<Analytics> getAllAnalytics() {
        return analyticsRepository.findAll();
    }

    @Override
    public Analytics updateAnalytics(Long idReport, Analytics analytics) {
        if (analyticsRepository.existsById(idReport)) {
            analytics.setId(idReport);
            return analyticsRepository.save(analytics);
        }
        return null;
    }

    @Override
    public void deleteAnalytics(Long idReport) {
        analyticsRepository.deleteById(idReport);
    }


    @Autowired
    public void AnalyticsReportService(AnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }

    public List<Analytics> getReportsByDateRange(LocalDate startDate, LocalDate endDate) {
        return analyticsRepository.findByGeneratedAtBetween(startDate, endDate);
    }



    public List<User> getMostActiveUsers() {
        List<Analytics> analyticsList = analyticsRepository.findAll(); // Get all analytics reports
        Map<Long, Integer> userActivityCount = analyticsList.stream()
                .flatMap(analytics -> analytics.getUsers().stream()) // Flatten the list of users
                .collect(Collectors.groupingBy(User::getUserId, Collectors.summingInt(user -> 1)));

        // Find the top 5 most active users
        List<Long> mostActiveUserIds = userActivityCount.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Retrieve the User objects for the most active users
        return userRepository.findAllById(mostActiveUserIds);
    }
}
