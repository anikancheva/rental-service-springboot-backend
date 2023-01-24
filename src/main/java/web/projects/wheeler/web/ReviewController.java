package web.projects.wheeler.web;

import org.springframework.web.bind.annotation.RestController;
import web.projects.wheeler.service.ReviewService;

@RestController("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}
