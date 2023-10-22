package com.example.analytics.AnalyticsReport.Repository;

import com.example.analytics.AnalyticsReport.Model.Analytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnalyticsRepository extends JpaRepository<Analytics,Long> {

    List<Analytics> findByGeneratedAtBetween(LocalDate startDate, LocalDate endDate);
}
