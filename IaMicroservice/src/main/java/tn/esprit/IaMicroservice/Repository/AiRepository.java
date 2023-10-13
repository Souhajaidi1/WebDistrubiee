package  tn.esprit.IaMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.IaMicroservice.Entity.AiModel;


@Repository
public interface AiRepository extends JpaRepository<AiModel, Long> {
}