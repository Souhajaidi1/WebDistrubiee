package tn.esprit.mspostcommentaire.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.esprit.mspostcommentaire.Entities.Comment;
import tn.esprit.mspostcommentaire.interfaces.ICommentaireService;

@RequestMapping("/Forum/Commentaire")
@AllArgsConstructor
@RestController
public class CommentaireController {

    @Autowired
    ICommentaireService commentaireService;


    @PostMapping("/ajouter-com")
    public Comment ajouterCom(@RequestBody Comment c) {
        return commentaireService.ajouterCom(c);
    }

    @GetMapping("/listCom")

    public List<Comment> getAllCom() {
        return commentaireService.getAllCom();

    }

    @GetMapping("/getCom/{idCom}")
    public Comment getComById(@PathVariable("idCom") Long idCom) {
        return commentaireService.getComById(idCom);
    }


    @PutMapping("/modifierPost/{idCom}")
    @ResponseBody
    public void updateCom(@RequestBody Comment c, @PathVariable("idCom") Long idCom) {
        commentaireService.updateCom(c, idCom);
    }


    @DeleteMapping("/deletePost/{idCom}")
    @ResponseBody
    public void deleteCom(@PathVariable("idCom") Long idCom) {
        commentaireService.deleteCom(idCom);
    }


    @PostMapping("/assign_Commentaire_To_User/{IdCom}/{IdUser}")
    @ResponseBody
    public void assignCommentToUser(@PathVariable("IdCom") Long IdCom, @PathVariable("IdUser") Long IdUser) {
        commentaireService.assignCommentToUser(IdCom, IdUser);

    }

    @PostMapping("/AddCommentPub/{idPost}/{idUser}")
    @ResponseBody
    public String AddCommentPub(@RequestBody Comment commentD,@PathVariable Long idPost,@PathVariable Long idUser) {
        //commentaireService.AddCommentPub(commentD,idPost, idUser);
        //return "Comment added successfuly " ;
        //try {
             return  commentaireService.AddCommentPub(commentD,idPost, idUser);

              // ResponseEntity.ok().build().toString();
        //} catch (EntityNotFoundException e) {
          //  return ResponseEntity.notFound().build().toString();
        //} catch (IllegalArgumentException e) {
         //   return ResponseEntity.badRequest().build().toString();
        //}

    }



    }