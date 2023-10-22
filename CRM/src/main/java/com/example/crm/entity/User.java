package com.example.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "customer_id") // Name of the foreign key column in the User table
    private Customer customer; // Many-to-One association with Customer entity


    // Constructors, additional fields, getters/setters
}
