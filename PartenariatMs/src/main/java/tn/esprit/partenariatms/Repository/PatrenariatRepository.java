package tn.esprit.partenariatms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.partenariatms.Entity.Partenariat;

import java.util.List;


@Repository
public interface PatrenariatRepository extends JpaRepository<Partenariat,Long> {
    List<Partenariat> obtenirPartenariatsExpirés();
}
