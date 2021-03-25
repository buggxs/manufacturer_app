package de.digitalstreich.Manufact.db;

import de.digitalstreich.Manufact.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
