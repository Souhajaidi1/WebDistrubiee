package com.example.reclamation.model;

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
public class Reclamation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idReclamation;
    private String contenu;
    private String etat;
    private Date date;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> users;

    public void setId(Long id) {
    }
}
