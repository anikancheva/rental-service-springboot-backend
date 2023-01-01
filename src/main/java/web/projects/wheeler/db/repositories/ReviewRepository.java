package web.projects.wheeler.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projects.wheeler.db.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
