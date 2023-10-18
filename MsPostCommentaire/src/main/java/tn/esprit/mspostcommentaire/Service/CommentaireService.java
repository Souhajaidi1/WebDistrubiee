package tn.esprit.mspostcommentaire.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.mspostcommentaire.Entities.Comment;
import tn.esprit.mspostcommentaire.Repositories.ICommentaireRepository;
import tn.esprit.mspostcommentaire.Repositories.IPostRepository;
import tn.esprit.mspostcommentaire.Repositories.UserRepository;
import tn.esprit.mspostcommentaire.interfaces.ICommentaireService;

@Service
@Slf4j
@Getter
@Setter
public  class CommentaireService implements ICommentaireService {

    @Autowired
    ICommentaireRepository commentaireRepository;
    @Autowired

    UserRepository userRepository;
    @Autowired

    IPostRepository postRepository;
   


    @Override
    public Comment ajouterCom(Comment c) {
        return null;
    }

    @Override
    public List<Comment> getAllCom() {
        return (List<Comment>) commentaireRepository.findAll();
    }

    @Override
    public Comment getComById(Long idCom) {
        return commentaireRepository.findById(idCom).get();
    }

    @Override
    public void deleteCom(Long id) {
        Comment c = commentaireRepository.findById(id).orElse(null);
        commentaireRepository.delete(c);
    }

    
    @Override
    public void updateCom(Comment comment, Long idCom) {
        Comment co = commentaireRepository.findById(idCom).orElse(null);

        co.setIdCom(idCom);
        co.setContentCom(comment.getContentCom());
        commentaireRepository.save(co);

    }

    @Override
    public void assignCommentToUser(Long IdCom, Long IdUser) {

    }

    @Override
    public String AddCommentPub(Comment commentD, Long idPost, Long idUser) {
        return null;
    }

    @Override
    public Comment ajouterComment(Comment c) {
        return null;
    }
    
/*
    @Override
    public void assignCommentToUser(Long IdCom, Long IdUser) {

        Commentaire c = commentaireRepository.findById(IdCom).get();
        User user = userRepository.findById(IdUser).get();
        c.setUserCommenter(user);

        // updatePost(p, p.getIdPost());
        commentaireRepository.save(c);
    }

    @Override
    public String AddCommentPub(Commentaire commentD, Long idPost, Long idUser) {

        Post p = postRepository.findById(idPost).get();
        User u = userRepository.findById(idUser).get();

        commentD.setUserCommenter(u);

        String textbody= commentD.getContentCom();
        List<Forbiden> badwordlist = (List<Forbiden>) forbidenRep.findAll();



        for (Forbiden forbiden : badwordlist) {
            String badword = forbiden.getText();
            String replace = String.join("", Collections.nCopies(badword.length(), "*"));
            textbody = textbody.replaceAll("(?i)" + badword, replace);
        }
        commentD.setContentCom(textbody);
        commentD.setPost(p);
        commentaireRepository.save(commentD);
        return "Comment added successfully";


    }

	@Override
	public void assignCommentToUser(Long IdCom, Long IdUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String AddCommentPub(Commentaire commentD, Long idPost, Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}