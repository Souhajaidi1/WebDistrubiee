package tn.esprit.partenariatms.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long partenariatId; // Identifiant du partenariat évalué
    private int note; // Note donnée par l'utilisateur
    private String commentaire;

    // Getters et setters
}
