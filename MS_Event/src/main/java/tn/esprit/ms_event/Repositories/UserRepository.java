package tn.esprit.ms_event.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ms_event.Entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
