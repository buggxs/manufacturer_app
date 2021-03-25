package de.digitalstreich.Manufact.db;

import de.digitalstreich.Manufact.model.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
