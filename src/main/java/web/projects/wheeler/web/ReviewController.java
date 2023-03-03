package web.projects.wheeler.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.projects.wheeler.db.entities.Review;
import web.projects.wheeler.models.AddReviewModel;
import web.projects.wheeler.service.ReviewService;

import java.net.URI;

@RestController
@RequestMapping("/reviews")
@CrossOrigin
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

    @GetMapping("/like/{id}")
    public ResponseEntity<String> likeReview(@PathVariable Long id){
        reviewService.like(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/dislike/{id}")
    public ResponseEntity<String> dislikeReview(@PathVariable Long id){
        reviewService.dislike(id);
        return ResponseEntity.ok().build();
    }
}
