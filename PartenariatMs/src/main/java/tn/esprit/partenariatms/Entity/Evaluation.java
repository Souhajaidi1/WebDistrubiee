package tn.esprit.partenariatms.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int note; // Note donnée par l'utilisateur
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "partenariatId")
    private Partenariat partenariat;
    // Getters et setters
}
