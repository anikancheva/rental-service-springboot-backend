package web.projects.wheeler.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projects.wheeler.db.auth.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
