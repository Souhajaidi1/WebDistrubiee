package tn.esprit.partenariatms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.partenariatms.Entity.Partenariat;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PatrenariatRepository extends JpaRepository<Partenariat,Long> {
    @Query("SELECT p FROM Partenariat p WHERE p.dateExpiration < :date")
    List<Partenariat> obtenirPartenariatsExpires(@Param("date") LocalDate date);

}
