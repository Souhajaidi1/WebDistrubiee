package com.example.postcomment.services;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.postcomment.interfaces.ICommentaireService;
import com.example.postcomment.entities.Commentaire;
import com.example.postcomment.entities.Post;
import com.example.postcomment.repositories.ICommentaireRepository;
import com.example.postcomment.repositories.IPostRepository;
import com.example.postcomment.repositories.UserRepository;
import com.example.postcomment.entities.Forbiden;
import com.example.postcomment.entities.User;
import com.example.postcomment.repositories.ForbidenRepository;



import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@Getter
@Setter
public abstract class CommentaireService implements ICommentaireService {

    @Autowired
    ICommentaireRepository commentaireRepository;
    @Autowired

    UserRepository userRepository;
    @Autowired

    IPostRepository postRepository;
    @Autowired
    private ForbidenRepository forbidenRep ;

    @Override
    public Commentaire ajouterCom(Commentaire c) {
        Commentaire c1 = commentaireRepository.save(c);
        return c1;
    }

    @Override
    public List<Commentaire> getAllCom() {
        return (List<Commentaire>) commentaireRepository.findAll();
    }

    @Override
    public Commentaire getComById(Long idCom) {
        return commentaireRepository.findById(idCom).get();
    }

    @Override
    public void deleteCom(Long id) {
        Commentaire c = commentaireRepository.findById(id).orElse(null);
        commentaireRepository.delete(c);
    }

    
    @Override
    public void updateCom(Commentaire commentaire, Long idCom) {
        Commentaire co = commentaireRepository.findById(idCom).orElse(null);

        co.setIdCom(idCom);
        co.setContentCom(commentaire.getContentCom());
        commentaireRepository.save(co);

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















