package com.example.analytics.AnalyticsReport.Controller;


import com.example.analytics.AnalyticsReport.Model.Analytics;
import com.example.analytics.AnalyticsReport.Model.User;
import com.example.analytics.AnalyticsReport.Service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @PostMapping
    public Analytics createAnalytics(@RequestBody Analytics analytics) {
        return analyticsService.createAnalytics(analytics);
    }

    @GetMapping("/{idReport}")
    public Analytics getAnalyticsById(@PathVariable Long idReport) {
        return analyticsService.getAnalyticsById(idReport);
    }

    @GetMapping
    public List<Analytics> getAllAnalytics() {
        return analyticsService.getAllAnalytics();
    }

    @PutMapping("/{idReport}")
    public Analytics updateAnalytics(@PathVariable Long idReport, @RequestBody Analytics analytics) {
        return analyticsService.updateAnalytics(idReport, analytics);
    }

    @DeleteMapping("/{idReport}")
    public void deleteAnalytics(@PathVariable Long idReport) {
        analyticsService.deleteAnalytics(idReport);
    }

    @GetMapping("/reports-by-date")
    public List<Analytics> getReportsByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return analyticsService.getReportsByDateRange(startDate, endDate);
    }
    @GetMapping("/most-active-users")
    public List<User> getMostActiveUsers() {
        return analyticsService.getMostActiveUsers();
    }
}
