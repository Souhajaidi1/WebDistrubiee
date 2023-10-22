package tn.esprit.mspostcommentaire.interfaces;

import java.util.List;

import tn.esprit.mspostcommentaire.Entities.Comment;

public interface ICommentaireService {

    Comment ajouterCom(Comment c);
    List<Comment> getAllCom();
    Comment getComById(Long idCom);
    void deleteCom( Long id);
    void updateCom(Comment commentaire, Long idCom);

    void assignCommentToUser(Long IdCom, Long IdUser) ;
    String AddCommentPub(Comment commentD, Long idPost , Long idUser ) ;
	Comment ajouterComment(Comment c);






}