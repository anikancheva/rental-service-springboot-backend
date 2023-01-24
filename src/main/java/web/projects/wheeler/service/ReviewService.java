package web.projects.wheeler.service;

import org.springframework.stereotype.Service;
import web.projects.wheeler.db.repositories.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
}
