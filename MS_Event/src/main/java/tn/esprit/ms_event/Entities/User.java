package tn.esprit.ms_event.Entities;

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
public class User implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long userId;
        private String userName;
        private String password;
        private String firstName;
        private String lastName;
        private String phone;
        private String email;
        private Date birthDate;
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"))
        private Set<Role> roles;

        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(name = "user_event",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"),
                inverseJoinColumns = @JoinColumn(name = "event_id", referencedColumnName = "eventId"))
        private Set<Event> events;


    }
