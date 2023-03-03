package web.projects.wheeler.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import web.projects.wheeler.db.entities.Listing;
import web.projects.wheeler.db.entities.Review;
import web.projects.wheeler.db.entities.UserModel;
import web.projects.wheeler.db.repositories.ListingRepository;
import web.projects.wheeler.db.repositories.ReviewRepository;
import web.projects.wheeler.db.repositories.UserRepository;
import web.projects.wheeler.models.AddReviewModel;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ListingRepository listingRepository;

    private final UserRepository userRepository;

    public ReviewService(ReviewRepository reviewRepository, ListingRepository listingRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.listingRepository = listingRepository;
        this.userRepository = userRepository;
    }

    public Review addNewReview(AddReviewModel reviewModel) {

        Listing listing = listingRepository.findById(reviewModel.getListingId()).orElse(null);
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserModel author = userRepository.findByUsername(currentUserName).orElse(null);

        Review review = new Review()
                .setAuthor(author)
                .setListing(listing)
                .setContent(reviewModel.getContent());

        try {
            return reviewRepository.save(review);
        } catch (RuntimeException e) {
            return null;
        }
    }

    public void like(Long id) {
        Review review = reviewRepository.getReviewById(id);
        int increasedLikes = review.getLikes() + 1;
        review.setLikes(increasedLikes);
        reviewRepository.save(review);

    }

    public void dislike(Long id) {
        Review review = reviewRepository.getReviewById(id);
        int increasedDislikes = review.getDislikes() + 1;
        review.setDislikes(increasedDislikes);
        reviewRepository.save(review);
    }
}
