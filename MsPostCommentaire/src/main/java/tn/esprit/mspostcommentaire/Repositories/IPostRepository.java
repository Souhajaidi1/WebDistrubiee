package tn.esprit.mspostcommentaire.Repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.mspostcommentaire.Entities.Post;

@Repository
public interface IPostRepository extends CrudRepository<Post,Long> {

   // List<Post> findByUser(User user);
  // List<Commentaire> findByIdPost(Long idPost);

   List<Post> findByTitleContainingOrContentContaining(String keyword1, String keyword2);
   List<Post> findByUser_userNameContaining(String userName);
   List<Post> findByTitleContainingOrContentContainingAndUser_userNameContaining(String keyword1, String keyword2, String userName);

  List<Post> findByCommentsIsNullAndDateCreatedBefore(LocalDateTime threshold);
}
