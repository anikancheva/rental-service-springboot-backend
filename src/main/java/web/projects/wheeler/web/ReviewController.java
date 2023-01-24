package web.projects.wheeler.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.projects.wheeler.db.entities.Review;
import web.projects.wheeler.models.AddReviewModel;
import web.projects.wheeler.service.ReviewService;

import java.net.URI;

@RestController("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody AddReviewModel addReviewModel){
        Review review = reviewService.addNewReview(addReviewModel);

        if(null==review){
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.created(URI.create(String.format("/reviews/%d", review.getId()))).body(review);


    }
}
