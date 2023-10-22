package tn.esprit.partenariatms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.partenariatms.Entity.Evaluation;


@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
}
