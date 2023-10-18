package tn.esprit.mspostcommentaire.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment implements Serializable {

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
