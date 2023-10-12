package tn.esprit.prestationdeservice.msprestation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.prestationdeservice.msprestation.models.PrestationDeService;

import java.util.List;

@Repository
public interface PrestationDeServiceRepository extends JpaRepository<PrestationDeService, Long> {
    List<PrestationDeService> findByTypeAndTarificationBetween(String type, Double minTarification, Double maxTarification);

    List<PrestationDeService> findByTypeAndTarificationGreaterThanEqual(String type, Double minTarification);

    List<PrestationDeService> findByTypeAndTarificationLessThanEqual(String type, Double maxTarification);

    List<PrestationDeService> findByType(String type);

    List<PrestationDeService> findByTarificationBetween(Double minTarification, Double maxTarification);

    List<PrestationDeService> findByTarificationGreaterThanEqual(Double minTarification);

    List<PrestationDeService> findByTarificationLessThanEqual(Double maxTarification);

    List<PrestationDeService> findByTypeContaining(String partialType);

    Page<PrestationDeService> findAll(Pageable pageable);
}
