package com.example.reclamation.model;

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
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idReclamation;
    private String contenu;
    private String etat;
    private Date date;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "reclamation_users",
            joinColumns = @JoinColumn(name = "idReclamation"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;
}
