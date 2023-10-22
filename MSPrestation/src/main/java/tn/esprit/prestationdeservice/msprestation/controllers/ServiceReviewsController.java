package tn.esprit.prestationdeservice.msprestation.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.prestationdeservice.msprestation.models.ServiceReviews;
import tn.esprit.prestationdeservice.msprestation.services.ServiceReviewsService;


import java.util.List;

@RestController
@RequestMapping("/service-reviews")
public class ServiceReviewsController {

    @Autowired
    private ServiceReviewsService serviceReviewsService;

    @GetMapping("/list/service-reviews")
    public List<ServiceReviews> getAllServiceReviews() {
        return serviceReviewsService.getAllServiceReviews();
    }

    @GetMapping("/OneServiceReview/{reviewID}")
    public ServiceReviews getServiceReviewById(@PathVariable Long reviewID) {
        return serviceReviewsService.getServiceReviewById(reviewID);
    }

    @PostMapping("/add-service-review")
    public ServiceReviews createServiceReview(@RequestBody ServiceReviews review) {
        return serviceReviewsService.createServiceReview(review);
    }

    @PutMapping("/update-service-review/{reviewID}")
    public ServiceReviews updateServiceReview(@PathVariable Long reviewID, @RequestBody ServiceReviews updatedReview) {
        return serviceReviewsService.updateServiceReview(reviewID, updatedReview);
    }

    @DeleteMapping("/delete/{reviewID}")
    public boolean deleteServiceReview(@PathVariable Long reviewID) {
        return serviceReviewsService.deleteServiceReview(reviewID);
    }

    @GetMapping("/average-rating")
    public ResponseEntity<Double> getAverageRating() {
        double averageRating = serviceReviewsService.calculateAverageRating();
        return ResponseEntity.ok(averageRating);
    }
}
