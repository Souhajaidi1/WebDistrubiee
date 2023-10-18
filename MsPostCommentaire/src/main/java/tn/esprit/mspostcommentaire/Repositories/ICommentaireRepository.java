package tn.esprit.mspostcommentaire.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.mspostcommentaire.Entities.Comment;

@Repository
public interface ICommentaireRepository extends JpaRepository<Comment,Long> {
}