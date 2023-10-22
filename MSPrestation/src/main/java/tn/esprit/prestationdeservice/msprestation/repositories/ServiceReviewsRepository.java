package tn.esprit.prestationdeservice.msprestation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.prestationdeservice.msprestation.models.ServiceReviews;

@Repository
public interface ServiceReviewsRepository extends JpaRepository<ServiceReviews,Long> {
}
