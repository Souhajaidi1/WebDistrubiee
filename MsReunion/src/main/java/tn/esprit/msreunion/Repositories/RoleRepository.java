package tn.esprit.msreunion.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msreunion.Entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
