package tn.esprit.msreunion.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msreunion.Entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
