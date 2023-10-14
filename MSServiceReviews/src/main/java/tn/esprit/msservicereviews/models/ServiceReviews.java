package tn.esprit.msservicereviews.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
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

