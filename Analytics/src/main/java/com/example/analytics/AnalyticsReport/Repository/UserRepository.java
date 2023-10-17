package com.example.analytics.AnalyticsReport.Repository;

import com.example.analytics.AnalyticsReport.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
