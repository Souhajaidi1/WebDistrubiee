package tn.esprit.ms_event.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ms_event.Entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
