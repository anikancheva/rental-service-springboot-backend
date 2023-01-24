package web.projects.wheeler.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projects.wheeler.db.entities.UserModel;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

   Optional<UserModel> findByUsername(String username);
   Optional<UserModel> findByEmail(String email);
}
