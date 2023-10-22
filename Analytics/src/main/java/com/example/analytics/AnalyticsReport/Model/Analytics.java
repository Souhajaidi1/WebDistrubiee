package com.example.analytics.AnalyticsReport.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Analytics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReport;
    private String title;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date generatedAt;
    private String content;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "analytics_users",
            joinColumns = @JoinColumn(name = "idReport"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;


}
