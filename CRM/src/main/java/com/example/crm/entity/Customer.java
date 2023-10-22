package  com.example.crm.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String UserName;
    private String FirstName;
    private String LastName;
    private String Phone;
    private String BirthDate;

    private String email;
    private String password;

    // Additional fields and getters/setters

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<User> users; // One-to-Many association with User entity


}