package de.digitalstreich.Manufact.db;

import de.digitalstreich.Manufact.model.Productgroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductgroupRepository extends JpaRepository<Productgroup, Long> {
}
