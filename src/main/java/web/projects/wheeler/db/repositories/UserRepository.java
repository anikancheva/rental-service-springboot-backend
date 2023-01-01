package web.projects.wheeler.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projects.wheeler.db.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
