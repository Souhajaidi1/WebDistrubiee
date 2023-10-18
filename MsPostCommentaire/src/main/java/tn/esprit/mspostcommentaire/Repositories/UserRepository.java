package tn.esprit.mspostcommentaire.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.mspostcommentaire.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}