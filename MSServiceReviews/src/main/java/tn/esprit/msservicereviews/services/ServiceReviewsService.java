package tn.esprit.msservicereviews.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.msservicereviews.models.ServiceReviews;
import tn.esprit.msservicereviews.repositories.ServiceReviewsRepository;

import java.util.Date;
import java.util.List;

@Service
public class ServiceReviewsService {

    @Autowired
    private ServiceReviewsRepository serviceReviewsRepository;

    public List<ServiceReviews> getAllServiceReviews() {
        return serviceReviewsRepository.findAll();
    }

    public ServiceReviews getServiceReviewById(Long reviewID) {
        return serviceReviewsRepository.findById(reviewID).orElse(null);
    }

    public ServiceReviews createServiceReview(ServiceReviews review) {
        review.setCreationDate(new Date());
        return serviceReviewsRepository.save(review);
    }

    public ServiceReviews updateServiceReview(Long reviewID, ServiceReviews updatedReview) {
        ServiceReviews existingReview = serviceReviewsRepository.findById(reviewID).orElse(null);
        if (existingReview != null) {
            existingReview.setRating(updatedReview.getRating());
            existingReview.setReviewText(updatedReview.getReviewText());
            return serviceReviewsRepository.save(existingReview);
        }
        return null;
    }

    public boolean deleteServiceReview(Long reviewID) {
        if (serviceReviewsRepository.existsById(reviewID)) {
            serviceReviewsRepository.deleteById(reviewID);
            return true;
        }
        return false;
    }

    public double calculateAverageRating() {
        List<ServiceReviews> reviews = serviceReviewsRepository.findAll();

        if (reviews.isEmpty()) {
            return 0.0;
        }

        double totalRating = 0.0;
        for (ServiceReviews review : reviews) {
            totalRating += review.getRating();
        }

        return totalRating / reviews.size();
    }
}
