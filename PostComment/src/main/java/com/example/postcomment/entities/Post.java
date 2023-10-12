package com.example.postcomment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;
    private String title;
    private String content;

    private LocalDateTime dateCreated =LocalDateTime.now();
    private String imageP;

    private Long nbLikes = 0L;


    @ManyToOne(fetch  = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy= "post" ,cascade=CascadeType.ALL,orphanRemoval = true,  fetch = FetchType.LAZY)
    @JsonIgnore // ignore comments property during serialization
    private List<Commentaire> comments= new ArrayList<>();


    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "post_likes",
            joinColumns = { @JoinColumn(name = "post_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Set<User> likes = new HashSet<>();


	public Long getIdPost() {
		return idPost;
	}


	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public LocalDateTime getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}


	public String getImageP() {
		return imageP;
	}


	public void setImageP(String imageP) {
		this.imageP = imageP;
	}


	public Long getNbLikes() {
		return nbLikes;
	}


	public void setNbLikes(Long nbLikes) {
		this.nbLikes = nbLikes;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Commentaire> getComments() {
		return comments;
	}


	public void setComments(List<Commentaire> comments) {
		this.comments = comments;
	}


	public Set<User> getLikes() {
		return likes;
	}


	public void setLikes(Set<User> likes) {
		this.likes = likes;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
