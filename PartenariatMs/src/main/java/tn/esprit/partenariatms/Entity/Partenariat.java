package tn.esprit.partenariatms.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Partenariat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private Date dateCreation;
    private Date dateExpiration;
    private boolean actif;

    // Getters and setters
    @OneToMany(mappedBy = "partenariat", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;

}
