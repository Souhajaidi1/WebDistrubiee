package com.example.analytics.AnalyticsReport.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Analytics {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idReport;
    private String title;
    private String description;
    private Date generatedAt;
    private String content;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> users;

    public void setId(Long id) {
    }
}
