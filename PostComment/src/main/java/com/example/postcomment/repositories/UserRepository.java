package com.example.postcomment.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.postcomment.entities.User;

//import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{


    Optional<User> findByUserName(String userName);


    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);


  // String assignChamberForUser(Long userId, Long chambreId);
}

