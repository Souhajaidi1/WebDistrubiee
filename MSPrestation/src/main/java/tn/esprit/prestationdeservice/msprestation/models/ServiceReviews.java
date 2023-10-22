package tn.esprit.prestationdeservice.msprestation.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewID;

    private int rating;

    @NotBlank
    @Size(max = 255)
    private String reviewText;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    // Constructors, getters, and setters
}

