package tn.esprit.mspostcommentaire.interfaces;

import java.util.List;

import tn.esprit.mspostcommentaire.Entities.Comment;
import tn.esprit.mspostcommentaire.Entities.Post;
import tn.esprit.mspostcommentaire.Entities.User;

public interface IPostService {


    Post ajouterPost(Post p);
    List<Post> getAllPosts();
    Post getPostById(Long idPost);
    void updatePost(Post post, Long idPost);
    void deletePost( Long id);
    void assignPostToUser( Post p, Long IdUser);
     //List<Post> getPostsByUser(Integer userId,User user);

    List<Comment> getCommentsByPoste(Long idPost);

    List<Post> searchByTitleOrContent(String keyword);
    List<Post> searchByUser(String nomUser);
    List<Post> searchByTitleOrContentAndUser(String keyword, String nomUser);
    void deleteUncommentedPosts();

    Post likePost(Long postId, User user);
    //String likePoste(Long idPost, Long idUser);

}