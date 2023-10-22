package com.example.feedback.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFeedback;
    private Date creationDate;
    private String subject;
    private String description;
    private String type;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "feedback_users",
            joinColumns = @JoinColumn(name = "idFeedback"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;
}

