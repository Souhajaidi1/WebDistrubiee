package com.example.postcomment.entities;

import java.util.*;

import javax.management.relation.Role;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import lombok.experimental.FieldDefaults;

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


    public User(String username, String email, String password,String phone) {
        this.userName = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User(String username, String email, String encode) {
        this.userName = username;
        this.email = email;
        this.password = encode;
    }

    public String getPhone() {
        return String.valueOf(phone);
    }
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"))
    private Set<Role> roles;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    /*@ManyToMany(mappedBy = "users")
    private Set<Events> events = new HashSet<>();
  /* @JsonIgnore
   @ManyToMany( cascade = CascadeType.ALL)
   private Set<Events> Evenements;
    @OneToMany(mappedBy="ratingOwner", fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Rating> listRatings;
*/
    

    
}
