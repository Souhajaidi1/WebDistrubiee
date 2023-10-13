package tn.esprit.IaMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.IaMicroservice.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}