package web.projects.wheeler.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projects.wheeler.db.Role;
import web.projects.wheeler.db.RoleType;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleByRole(RoleType role);
}
