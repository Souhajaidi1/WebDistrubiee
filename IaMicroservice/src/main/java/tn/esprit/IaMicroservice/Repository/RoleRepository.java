package tn.esprit.IaMicroservice.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.IaMicroservice.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}