package de.digitalstreich.Manufact.db;

import de.digitalstreich.Manufact.model.auth.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
