package web.projects.wheeler.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projects.wheeler.db.entities.Listing;
import web.projects.wheeler.db.entities.VehicleType;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Long> {
   List<Listing> findAllByVehicleType(VehicleType vehicleType);
}
