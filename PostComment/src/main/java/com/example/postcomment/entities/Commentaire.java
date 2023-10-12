package com.example.postcomment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Commentaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCom;
    private String contentCom;

    private LocalDateTime dateCreated =LocalDateTime.now();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "commenter_user")
    @JsonIgnore // ignore userCommenter property during serialization
    private User userCommenter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore // ignore post property during serialization
    private Post post;

	public Object getIdCom() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getContentCom() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setContentCom(Object contentCom2) {
		// TODO Auto-generated method stub
		
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUserCommenter() {
		return userCommenter;
	}

	public void setIdCom(Long idCom) {
		this.idCom = idCom;
	}

	public void setContentCom(String contentCom) {
		this.contentCom = contentCom;
	}

	public void setUserCommenter(User user) {
		// TODO Auto-generated method stub
		
	}


}
