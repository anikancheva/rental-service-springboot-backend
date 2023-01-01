package web.projects.wheeler.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projects.wheeler.db.entities.Listing;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}
