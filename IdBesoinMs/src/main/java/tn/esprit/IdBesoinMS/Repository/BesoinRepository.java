package tn.esprit.IdBesoinMS.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.IdBesoinMS.Entity.Besoin;

import java.util.List;

@Repository
public interface BesoinRepository extends JpaRepository<Besoin, Long> {

    int countByStatut(Besoin.Statut statut);

    /*
    List<Besoin> findByStatut(Besoin.Statut statut);
    List<Besoin> findByDescriptionContaining(String motCle);
    List<Besoin> findByNumeroContaining(String motCle);
    List<Besoin> findByMarqueContaining(String motCle);  */

    List<Besoin> findBesoinsByMotCle(String motCle);
}
