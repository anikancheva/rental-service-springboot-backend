package web.projects.wheeler.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projects.wheeler.db.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle getVehicleByOwnerId(Long id);
}
