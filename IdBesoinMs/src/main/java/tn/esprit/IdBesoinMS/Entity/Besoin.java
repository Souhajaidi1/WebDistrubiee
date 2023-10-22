package tn.esprit.IdBesoinMS.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Besoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String Marque;

    @NotNull
    private Long Numero;

    private Long CapitalSocial;

    @NotBlank
    @Size(min = 1, max = 1000)
    private String description;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSoumission;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    public Besoin(Statut statut, int rejeteCount) {
    }
 private  String motCle ;

    public enum Statut {
        EN_ATTENTE("En attente"),
        APPROUVE("Approuvé"),
        REJETE("Rejeté");

        private final String libelle;

        Statut(String libelle) {
            this.libelle = libelle;
        }

        public String getLibelle() {
            return libelle;
        }
    }


}
