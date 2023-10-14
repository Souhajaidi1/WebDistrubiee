package tn.esprit.msservicereviews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.msservicereviews.models.ServiceReviews;

@Repository
public interface ServiceReviewsRepository extends JpaRepository<ServiceReviews,Long> {
}
