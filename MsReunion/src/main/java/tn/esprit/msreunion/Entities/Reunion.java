package tn.esprit.msreunion.Entities;

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
@NoArgsConstructor
@AllArgsConstructor
public class Reunion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reunionId;
    @Temporal(TemporalType.DATE)
    private Date dateReunion;
    private String location;
    private String agenda;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "reunion_attendees",
            joinColumns = @JoinColumn(name = "reunion_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> attendees;
}
